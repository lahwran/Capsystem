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
    
    public Capsystem()
    {
        maxLength=60;
        prefix = colorchar + "0" + colorchar + "0" + colorchar + "0" + colorchar + "0";
        doneprefix = prefix;
    }
    
    private final HashMap<Player, Caplist> playercaps = new HashMap<Player, Caplist>();
    
    public synchronized static void registerCap(String c) { instance._registerCap(c); }
    public synchronized static void registerCap(Capability c) { instance._registerCap(c); }
    public synchronized static void unregisterCap(String c) { instance._unregisterCap(c); }
    public synchronized static void unregisterCap(Capability c) { instance._unregisterCap(c); }
    
    public synchronized static boolean hasCap(Player p, String c)
    {
        return instance.playercaps.get(p) != null && instance.playercaps.get(p).capabilities.containsKey(c);
    }

    public synchronized static boolean hasCap(Player p, Capability c)
    {
        return instance.playercaps.get(p) != null && instance.playercaps.get(p).capabilities.containsKey(c.type+c.name);
    }

    public synchronized static Capability getCap(Player p, String c)
    {
        return instance.playercaps.get(p) != null ? instance.playercaps.get(p).capabilities.get(c) : null;
    }

    public synchronized static Caplist getCapList(Player p)
    {
        return instance.playercaps.get(p);
    }

    public synchronized static void sendCaps(Player p)
    {
        for(String line:instance.capLines())
        {
            p.sendRawMessage(line);
        }
        Commsystem._ready(p);
    }

    static synchronized void _addCap(Player sender, String cap)
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
    public synchronized static void clearCaps(Player r)
    {
        instance.playercaps.remove(r);
    }
}
