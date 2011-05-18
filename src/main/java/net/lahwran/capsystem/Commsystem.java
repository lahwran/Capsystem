/**
 * 
 */
package net.lahwran.capsystem;

import java.util.HashMap;

/**
 * @author lahwran
 *
 */
public class Commsystem {
    public static final String fieldSeparator = "\u00d7";
    private static final HashMap<String, Commplugin> plugins = new HashMap<String, Commplugin>();
    public static Commplugin register(String identification, CommeventListener listener)
    {
        if (identification.length() != 4)
            throw new IllegalArgumentException("Identification provided ('"+identification+"') is not of length 4");
        if (plugins.containsKey(identification))
            throw new RuntimeException("Already have a plugin with identification "+identification);
        Commplugin newplugin = new Commplugin(identification, listener);
        plugins.put(identification, newplugin);
        return newplugin;
    }

    public static void dispatch(String input)
    {
        String identification = input.substring(0, 4);
        Commplugin plugin = plugins.get(identification);
        String data = input.substring(4);
        if (plugin == null)
        {
            System.err.println("Got a message for Commplugin '"+identification+"', no such plugin (data: '"+data+"')");
            return;
        }
        plugin.processMessage(data);
    }

    public static final String commprefix = "/@comm ";

    static {
        Capsystem.registerCap("+comm:v0");
    }

    public static void _ready()
    {
        for(Commplugin p:plugins.values())
        {
            p._ready();
        }
    }
}
