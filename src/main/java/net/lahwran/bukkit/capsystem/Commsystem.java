/**
 * 
 */
package net.lahwran.bukkit.capsystem;

import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;

import net.lahwran.capsystem.GenericCommplugin;
import net.lahwran.capsystem.GenericCommsystem;

/**
 * @author lahwran
 *
 */
public class Commsystem extends GenericCommsystem {

    public static Commsystem instance = new Commsystem();
    private Commsystem() 
    {
        _init(Capsystem.instance);
        commprefix = Capsystem.instance.colorchar + "0" +Capsystem.instance.colorchar + "0" ;
    }

    public static Commplugin register(String identification, CustomEventListener listener)
    {
        return (Commplugin)instance._register(identification, listener);
    }
    
    @Override
    protected GenericCommplugin getNewPlugin(String identification, Object listener)
    {
        return (GenericCommplugin)new Commplugin(identification, (CustomEventListener)listener);
    }

    /**
     * @param sender
     * @param string
     */
    public static void dispatch(Player player, String chat)
    {
        Commplugin p = (Commplugin)instance.fetchPlugin(chat);
        if (p == null) return;
        p.dispatchMessage(player, chat.substring(4));
    }

    /**
     * could be done by calling bukkit's event system ... bleh ...
     */
    static synchronized void _ready(Player player)
    {
        for(GenericCommplugin p:instance.plugins.values())
        {
            ((Commplugin)p).listener.onCustomEvent(new Readyevent(player));
        }
        
    }

    
}
