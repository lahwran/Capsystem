/**
 * 
 */
package net.lahwran.bukkit.capsystem;

import java.util.HashMap;
import java.util.regex.Matcher;

import org.bukkit.entity.Player;

import net.lahwran.capsystem.Capability;
import net.lahwran.capsystem.Caplist;
import net.lahwran.capsystem.GenericCapsystem;


/**
 * @author lahwran
 *
 */
public class Capsystem extends GenericCapsystem {
    
    static Capsystem instance = new Capsystem();
    
    public int maxLength=60;
    public String prefix = colorchar + "0" + colorchar + "0" + colorchar + "0" + colorchar + "0";
    public String doneprefix = prefix;
    private final HashMap<Player, Caplist> playercaps = new HashMap<Player, Caplist>();
    
    public static void registerCap(String c) { instance._registerCap(c); }
    public static void registerCap(Capability c) { instance._registerCap(c); }
    public static void unregisterCap(String c) { instance._unregisterCap(c); }
    public static void unregisterCap(Capability c) { instance._unregisterCap(c); }
    
    public static boolean hasCap(Player p, String c)
    {
        return instance.playercaps.get(p) != null && instance.playercaps.get(p).capabilities.containsKey(c);
    }

    public static boolean hasCap(Player p, Capability c)
    {
        return instance.playercaps.get(p) != null && instance.playercaps.get(p).capabilities.containsKey(c.type+c.name);
    }

    public static Capability getCap(Player p, String c)
    {
        return instance.playercaps.get(p) != null ? instance.playercaps.get(p).capabilities.get(c) : null;
    }

    public static Caplist getCapList(Player p)
    {
        return instance.playercaps.get(p);
    }

    public static void sendCaps(Player p)
    {
        for(String line:instance.capLines())
        {
            p.sendRawMessage(line);
        }
    }

    static void _addCap(Player sender, String cap)
    {
        Matcher match = cappattern.matcher(cap);
        if (!match.matches())
            throw new RuntimeException("String is not a capability: "+cap);
        String type = match.group(1);
        String name = match.group(2);
        String args = match.group(3);
        Caplist list = instance.playercaps.get(sender);
        if (list == null)
        {
            if (!type.equals("v"))
            {
                System.err.println("Capability is not version-type: "+cap);
                return;
            }
            list = new Caplist(Integer.parseInt(name), sender.getName());
            instance.playercaps.put(sender, list);
        }
        else
        {
            list.capabilities.put(type+name, new Capability(type, name, args));
        }
    }
    public static void clearCaps(Player r)
    {
        instance.playercaps.remove(r);
    }
}
