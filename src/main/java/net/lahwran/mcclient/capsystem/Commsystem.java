/**
 * 
 */
package net.lahwran.mcclient.capsystem;

import net.lahwran.capsystem.GenericCommplugin;
import net.lahwran.capsystem.GenericCommsystem;

/**
 * @author lahwran
 *
 */
public class Commsystem extends GenericCommsystem{

    static final Commsystem instance = new Commsystem();
    private Commsystem() 
    { 
        _init(Capsystem.instance);
        commprefix = "/@comm ";
    }
    
    public static Commplugin register(String identification, CommListener listener)
    {
        return (Commplugin)instance._register(identification, listener);
    }
    
    @Override
    protected GenericCommplugin getNewPlugin(String identification, Object listener)
    {
        return new Commplugin(identification, (CommListener)listener);
    }

    static void _ready()
    {
        for(GenericCommplugin p:instance.plugins.values())
        {
            ((Commplugin)p).listener.onConnect();
        }
    }

    static void dispatch(String chat)
    {
        Commplugin p = (Commplugin)instance.fetchPlugin(chat);
        if (p == null) return;
        p.dispatchMessage(chat.substring(4));
    }
}
