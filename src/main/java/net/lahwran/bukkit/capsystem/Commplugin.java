/**
 * 
 */
package net.lahwran.bukkit.capsystem;

import net.lahwran.capsystem.GenericCommplugin;
import net.lahwran.capsystem.commdata.Commdata;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;


/**
 * @author lahwran
 *
 */
public class Commplugin extends GenericCommplugin {

    private final HashMap<Player, StringBuilder> messageBuffers = new HashMap<Player, StringBuilder>();
    final CustomEventListener listener;

    /**
     * @param identification
     * @param listener
     */
    Commplugin(String identification, CustomEventListener listener)
    {
        this.identification = identification;
        this.listener = listener;
    }

    @Override
    protected void freeMessageBuffer(Object bufferid)
    {
        messageBuffers.remove((Player)bufferid);
    }

    @Override
    protected StringBuilder getMessageBuffer(Object bufferid)
    {
        return messageBuffers.get((Player)bufferid);
    }

    @Override
    protected String getPrefix()
    {
        return Commsystem.instance.commprefix;
    }

    @Override
    protected StringBuilder makeMessageBuffer(Object bufferid)
    {
        StringBuilder newbuffer = new StringBuilder();
        messageBuffers.put((Player)bufferid, newbuffer);
        return newbuffer;
    }

    void dispatchMessage(Player player, String message)
    {
        String result = processMessage(message, null);
        if(result == null)
            return; //nothing to do
        listener.onCustomEvent(new Commevent(player, getEventData(result)));
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void sendMessage(Player target, Commdata... commdatas)
    {
        if(commdatas.length == 0)
            return;
        for(String line:messageToLines(commdatas))
        {
            target.sendRawMessage(line);
        }
    }

}
