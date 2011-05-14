/**
 * 
 */
package net.lahwran.capsystem;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.entity.Player;
/**
 * @author lahwran
 *
 */
public class Capsystem {
    public static final int protocolVersion = 0;
    private static final HashMap<Player, Caplist> capabilities = new HashMap<Player, Caplist>();
    private static final Caplist serverCaplist = new Caplist(protocolVersion);

    public static void sendServerCaps(String prefix, Player p)
    {
        StringBuilder toSend = null;
        for (Capability c:serverCaplist.capabilities.values())
        {
            String curCap = c.toString();
            if(toSend == null)
            {
                toSend = new StringBuilder(prefix);
                if (toSend.length() + curCap.length() > 60)
                    throw new RuntimeException("Impossibly long capability error");
                toSend.append(curCap);
                continue;
            }
            else if(toSend.length() + curCap.length() + 1 > 60)
            {
                System.out.println("Sending "+toSend.length()+": "+toSend.toString());
                p.sendRawMessage(toSend.toString());
                toSend=null;
            }
            else
            {
                toSend.append(" "+curCap);
            }
        }
        if (toSend != null)
        {
            System.out.println("Sending: "+toSend.toString());
            p.sendRawMessage(toSend.toString());
        }
    }

    public static void registerCap(Capability c)
    {
        serverCaplist.capabilities.put(c.type+c.name, c);
    }

    public static void registerCap(String strc)
    {
        Capability c = new Capability(strc);
        serverCaplist.capabilities.put(c.type+c.name, c);
    }

    public static void unregisterCap(Capability c)
    {
        serverCaplist.capabilities.remove(c.type+c.name);
    }

    public static void unregisterCap(String c)
    {
        serverCaplist.capabilities.remove(c);
    }

    public static boolean hasCap(Player p, String c)
    {
        return capabilities.get(p) != null && capabilities.get(p).capabilities.containsKey(c);
    }

    public static boolean hasCap(Player p, Capability c)
    {
        return capabilities.get(p) != null && capabilities.get(p).capabilities.containsKey(c.type+c.name);
    }

    public static Capability getCap(Player p, String c)
    {
        return capabilities.get(p) != null ? capabilities.get(p).capabilities.get(c) : null;
    }

    public static Caplist getCapList(Player p)
    {
        return capabilities.get(p);
    }

    public static final Pattern cappattern = Pattern.compile("^(.)([^:]*):?(.*)?$");
    public static void addCap(Player p, String cap)
    {
        Caplist list =  capabilities.get(p);
        Matcher match = cappattern.matcher(cap);
        if (!match.matches())
            throw new RuntimeException("String is not a capability: "+cap);
        String type = match.group(1);
        String name = match.group(2);
        String args = match.group(3);
        if (list == null)
        {
            if (!type.equals("v"))
            {
                System.err.println("Capability is not version-type: "+cap);
                return;
            }
            list = new Caplist(Integer.parseInt(name), p.getName());
            capabilities.put(p, list);
        }
        else
        {
            list.capabilities.put(type+name, new Capability(type, name, args));
        }
    }

    public static void clearCaps(Player p)
    {
        capabilities.remove(p);
    }
}
