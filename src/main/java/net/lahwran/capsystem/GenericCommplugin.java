/**
 * 
 */
package net.lahwran.capsystem;

import java.util.ArrayList;

import net.lahwran.capsystem.commdata.Commdata;

/**
 * @author lahwran
 *
 */
public abstract class GenericCommplugin {
    protected String identification;
    //private HashMap<Player, StringBuilder> messageBuffers = new HashMap<Player, StringBuilder>();
    //private final CommeventListener listener;
    //private StringBuilder messageBuffer = new StringBuilder();
    protected int maxlength;

    protected abstract StringBuilder getMessageBuffer(Object bufferid);
    protected abstract StringBuilder makeMessageBuffer(Object bufferid);
    protected abstract void freeMessageBuffer(Object bufferid);
    protected abstract String getPrefix();

    protected String processMessage(String message, Object bufferid)
    {
        boolean iscontinued = message.startsWith(GenericCommsystem.fieldSeparator);
        if(iscontinued) message = message.substring(1);
            
        boolean continueagain = message.endsWith(GenericCommsystem.fieldSeparator);
        if(continueagain) message = message.substring(0, message.length()-1);
        
        StringBuilder curMessageBuffer = null;
        if (iscontinued)
        {
            curMessageBuffer = getMessageBuffer(bufferid);
            if(curMessageBuffer == null)
            {
                System.err.println("Tried to continue message with no previous message! "+identification+message);
                return null;
            }
        }
        else if (continueagain)
        {
            curMessageBuffer = makeMessageBuffer(bufferid);
        }
        if (continueagain)
        {
            curMessageBuffer.append(message);
        }
        else if(iscontinued)
        {
            curMessageBuffer.append(message);
            freeMessageBuffer(bufferid);
            return curMessageBuffer.toString();
        }
        else
        {
            return message;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    protected Commdata[] getEventData(String message)
    {
        String[] split = message.split(GenericCommsystem.fieldSeparator);
        Commdata[] eventData = new Commdata[split.length];
        for(int i=0; i<split.length; i++)
        {
            eventData[i] = Commdata.selectDecoder(split[i]);
        }
        return eventData;
    }
    
    @SuppressWarnings("unchecked")
    protected String[] messageToLines(Commdata... commdatas)
    {
        if(commdatas.length == 0)
            return new String[0]; //is this an error?
        ArrayList<String> linebuilder = new ArrayList<String>();
        StringBuilder outmessage = new StringBuilder();
        for(int i = 0; i < commdatas.length; i++)
        {
            outmessage.append(commdatas[i].encoded());
            if (i < commdatas.length-1)
                outmessage.append(GenericCommsystem.fieldSeparator);
            
        }
        //TODO: this reserves spots for repeat markers even when not needed
        int msgcount = (outmessage.length()/maxlength) + 1;
        for(int i=0; i < msgcount; i++)
        {
            StringBuilder thismessage = new StringBuilder(getPrefix());
            thismessage.append(identification);
            if (i>0)
                thismessage.append(GenericCommsystem.fieldSeparator);
            thismessage.append(outmessage.substring(i * maxlength, i+1 * maxlength));
            if (i==msgcount-1)
                thismessage.append(GenericCommsystem.fieldSeparator);
            linebuilder.add(thismessage.toString());
        }
        return linebuilder.toArray(new String[0]);
    }

    public String getIdentification()
    {
        return identification;
    }
}
