/**
 * 
 */
package net.lahwran.capsystem;

import java.util.HashMap;

/**
 * @author lahwran
 *
 */
public abstract class GenericCommsystem {
    public static final String fieldSeparator = "\u00d7";
    public String commprefix; //  = "/@comm "
    // Capsystem.colorchar + "0" + Capsystem.colorchar + "0";
    
    protected final HashMap<String, GenericCommplugin> plugins = new HashMap<String, GenericCommplugin>();

    protected GenericCommplugin _register(String identification, Object listener)
    {
        if (identification.length() != 4)
            throw new IllegalArgumentException("Identification provided ('"+identification+"') is not of length 4");
        if (plugins.containsKey(identification))
            throw new RuntimeException("Already have a plugin with identification "+identification);
        GenericCommplugin newplugin = getNewPlugin(identification, listener);
        plugins.put(identification, newplugin);
        return newplugin;
    }

    protected abstract GenericCommplugin getNewPlugin(String identification, Object listener);

    protected GenericCommplugin fetchPlugin(String message)
    {
        String identification = message.substring(0, 4);
        GenericCommplugin plugin = plugins.get(identification);
        if (plugin == null)
            // TODO: Maybe should just print to stderr? traceback isn't useful...
            // TODO: is this even the right place for this check?
            throw new IllegalArgumentException("Got a message for Commplugin '"+identification+"', no such plugin (data: '"+message+"')");
        return plugin;
    }


    protected void _init(GenericCapsystem c)
    {
        c._registerCap("+comm:v0");
    }
}
