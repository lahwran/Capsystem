/**
 * 
 */
package net.lahwran.mcclient.capsystem;

import java.util.regex.Matcher;

import net.lahwran.capsystem.Capability;
import net.lahwran.capsystem.Caplist;
import net.lahwran.capsystem.GenericCapsystem;

/**
 * @author lahwran
 *
 */
public class Capsystem extends GenericCapsystem {

    static Capsystem instance = new Capsystem();
    
    public int maxLength=100;
    public String prefix = "/@caps ";
    public String doneprefix = "/@cap ";

    private Caplist serverCaplist = null;
    public Sendable server;
    public boolean connected = false;
    public boolean capableServer = false;
    
    public static void registerCap(String c) { instance._registerCap(c); }
    public static void registerCap(Capability c) { instance._registerCap(c); }
    public static void unregisterCap(String c) { instance._unregisterCap(c); }
    public static void unregisterCap(Capability c) { instance._unregisterCap(c); }
    
    public static boolean hasCap(String c)
    {
        return instance.serverCaplist != null && instance.serverCaplist.capabilities.containsKey(c);
    }

    public static boolean hasCap(Capability c)
    {
        return instance.serverCaplist != null && instance.serverCaplist.capabilities.containsKey(c.type+c.name);
    }

    public static Capability getCap(String c)
    {
        return instance.serverCaplist != null ? instance.serverCaplist.capabilities.get(c) : null;
    }

    public static Caplist getCapList()
    {
        return instance.serverCaplist;
    }
    
    void _addCap(String cap)
    {
        Matcher match = cappattern.matcher(cap);
        if (!match.matches())
            throw new RuntimeException("String is not a capability: "+cap);
        String type = match.group(1);
        String name = match.group(2);
        String args = match.group(3);
        serverCaplist.capabilities.put(type+name, new Capability(type, name, args));
    }
    
    void _initCaps(int version)
    {
        serverCaplist = new Caplist(version);
        capableServer = true;
        for(String line:capLines())
        {
            server.send(line);
        }
    }
    
    public static void _disconnected()
    {
        instance.serverCaplist = null;
        instance.server = null;
        instance.connected = false;
        instance.capableServer = false;
    }
    
    public static void _connectedToServer(Sendable r)
    {
        instance.server = r;
        instance.connected = true;
        instance.capableServer = false;
        instance.serverCaplist = null;
    }
}
