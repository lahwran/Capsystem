/**
 * 
 */
package net.lahwran.mcclient.capsystem;

import net.lahwran.capsystem.Capsystem;
import net.lahwran.capsystem.Commsystem;

/**
 * @author lahwran
 *
 */
public class ChatProcessor {
    private static final String cap = Capsystem.colorchar + "0" + Capsystem.colorchar + "0" + 
                                      Capsystem.colorchar + "0" + Capsystem.colorchar + "0";
    private static final String comm = Capsystem.colorchar + "0" + Capsystem.colorchar + "0";
    
    private static int colorDecode(String encoded)
    {
        StringBuilder hex = new StringBuilder();
        char colorchar = Capsystem.colorchar.charAt(0); //shouldn't it be a char to begin with?
        for(int i=0; i<encoded.length(); i++)
        {
            if(encoded.charAt(i) != colorchar)
            {
                hex.append(encoded.charAt(i));
            }
        }
        return Integer.parseInt(hex.toString(), 16);
    }
    
    public static boolean processChat(String chat)
    {
        if(chat.startsWith(cap))
        {
            chat = chat.substring(cap.length());
            if(Capsystem.connected && !Capsystem.capableServer)
            {
                Capsystem._initCaps(colorDecode(chat));
            }
            else if (chat.equals("done"))
            {
                Commsystem._ready();
            }
            else
            {
                String[] split = chat.split(" ");
                for (String s:split)
                {
                    Capsystem._addCap(s);
                }
            }
            return true;
        }
        else if(chat.startsWith(comm))
        {
            chat = chat.substring(comm.length());
            Commsystem.dispatch(chat);
            return true;
        }
        return false;
    }
}
