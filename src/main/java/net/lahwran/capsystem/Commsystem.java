/**
 * 
 */
package net.lahwran.capsystem;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;

/**
 * @author lahwran
 *
 */
public class Commsystem {
    public static final String fieldSeparator = "\u00d7";
    private static final HashMap<String, Commplugin> plugins = new HashMap<String, Commplugin>();
    public static Commplugin register(String identification, CustomEventListener listener)
    {
        if (identification.length() != 4)
            throw new IllegalArgumentException("Identification provided ('"+identification+"') is not of length 4");
        if (plugins.containsKey(identification))
            throw new RuntimeException("Already have a plugin with identification "+identification);
        Commplugin newplugin = new Commplugin(identification, listener);
        plugins.put(identification, newplugin);
        return newplugin;
    }

    public static void dispatch(Player p, String input)
    {
        String identification = input.substring(0, 4);
        Commplugin plugin = plugins.get(identification);
        String data = input.substring(4);
        if (plugin == null)
            // TODO: Maybe should just print to stderr? traceback isn't useful...
            throw new IllegalArgumentException("Got a message for Commplugin '"+identification+"', no such plugin ("+p.getName()+" data: '"+data+"')");
        plugin.processMessage(p, data);
    }
}
