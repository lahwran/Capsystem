/**
 * 
 */
package net.lahwran.capsystem;

import java.util.HashMap;

import net.lahwran.capsystem.commdata.Commdata;

import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;

/**
 * @author lahwran
 *
 */
public class Commplugin {
    public final String identification;
    private final CustomEventListener listener;
    private HashMap<Player, StringBuilder> messageBuffers = new HashMap<Player, StringBuilder>();
    Commplugin(String identification, CustomEventListener listener)
    {
        this.identification = identification;
        this.listener = listener;
    }

    public void processMessage(Player p, String message)
    {
        boolean iscontinued = message.startsWith(Commsystem.fieldSeparator);
        if(iscontinued) message = message.substring(1);
            
        boolean continueagain = message.endsWith(Commsystem.fieldSeparator);
        if(continueagain) message = message.substring(0, message.length()-1);
        
        StringBuilder messageBuffer = null;
        if (iscontinued)
        {
            messageBuffer = messageBuffers.get(p);
            if(messageBuffer == null)
            {
                System.err.println("Tried to continue message with no previous message! "+p.getName()+" "+identification+message);
                return;
            }
        }
        else if (continueagain)
        {
            messageBuffer = new StringBuilder();
            messageBuffers.put(p, messageBuffer);
        }
        
        if (continueagain)
        {
            messageBuffer.append(message);
        }
        else if(iscontinued)
        {
            messageBuffer.append(message);
            fire(p, messageBuffer.toString());
            messageBuffers.remove(p);
        }
        else
        {
            fire(p, message);
        }
    }

    private void fire(Player p, String message)
    {
        String[] split = message.split(Commsystem.fieldSeparator);
        Commdata[] eventData = new Commdata[split.length];
        for(int i=0; i<split.length; i++)
        {
            eventData[i] = Commdata.selectDecoder(split[i]);
        }
        listener.onCustomEvent(new Commevent(p, eventData));
    }
    public void send(Player p, Commdata... commdatas)
    {
        if(commdatas.length == 0)
            return;
        StringBuilder outmessage = new StringBuilder();
        for(int i = 0; i < commdatas.length; i++)
        {
            outmessage.append(commdatas[i].encoded());
            if (i < commdatas.length-1)
                outmessage.append(Commsystem.fieldSeparator);
            
        }
        //TODO: this reserves spots for repeat markers even when not needed
        int maxlength = Capsystem.maxLength-10;
        int msgcount = (outmessage.length()/maxlength) + 1;
        for(int i=0; i < msgcount; i++)
        {
            StringBuilder thismessage = new StringBuilder(Commsystem.commprefix);
            thismessage.append(identification);
            if (i>0)
                thismessage.append(Commsystem.fieldSeparator);
            thismessage.append(outmessage.substring(i * maxlength, i+1 * maxlength));
            if (i==msgcount-1)
                thismessage.append(Commsystem.fieldSeparator);
            p.sendRawMessage(thismessage.toString());
        }
    }
}
