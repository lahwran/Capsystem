/**
 * 
 */
package net.lahwran.capsystem;

import net.lahwran.capsystem.commdata.Commdata;


/**
 * @author lahwran
 *
 */
public class Commplugin {
    public final String identification;
    private final CommeventListener listener;
    private StringBuilder messageBuffer = new StringBuilder();
    Commplugin(String identification, CommeventListener listener)
    {
        this.identification = identification;
        this.listener = listener;
    }

    public void processMessage(String message)
    {
        boolean iscontinued = message.startsWith(Commsystem.fieldSeparator);
        if(iscontinued) message = message.substring(1);

        boolean continueagain = message.endsWith(Commsystem.fieldSeparator);
        if(continueagain) message = message.substring(0, message.length()-1);

        if (iscontinued)
        {
            if(messageBuffer == null)
            {
                System.err.println("Tried to continue message with no previous message! "+identification+message);
                return;
            }
        }
        else if (continueagain)
        {
            messageBuffer = new StringBuilder();
        }
        
        if (continueagain)
        {
            messageBuffer.append(message);
        }
        else if(iscontinued)
        {
            messageBuffer.append(message);
            fire(messageBuffer.toString());
            messageBuffer = null;
        }
        else
        {
            fire(message);
        }
    }

    private void fire(String message)
    {
        String[] split = message.split(Commsystem.fieldSeparator);
        Commdata[] eventData = new Commdata[split.length];
        for(int i=0; i<split.length; i++)
        {
            eventData[i] = Commdata.selectDecoder(split[i]);
        }
        listener.onCommevent(new Commevent(eventData));
    }
    public void send(Commdata... commdatas) throws ServerIncapableException, DisconnectedException
    {
        if(commdatas.length == 0)
            return; //is this an error?
        if(Capsystem.server == null)
            throw new DisconnectedException();
        if(!Capsystem.hasCap("+comm"))
            throw new ServerIncapableException("Server does not have commsystem");
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
            Capsystem.server.send(thismessage.toString());
        }
    }
}
