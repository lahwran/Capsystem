/**
 * 
 */
package net.lahwran.capsystem;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author lahwran
 *
 */
public abstract class GenericCapsystem {
    public static final int protocolVersion = 0;
    public static final Pattern cappattern = Pattern.compile("^(.)([^:]*):?(.*)?$");
    public static final char colorchar = '\u00a7';
    
    /** Our capabilities */
    private final Caplist caplist = new Caplist(protocolVersion);
    
    public int maxLength;
    public String prefix;
    public String doneprefix;
    
    /* /** Client stuff * /
    private static Caplist serverCaplist = null;
    public static Remote server;
    public static boolean connected = false;
    public static boolean capableServer = false;
    
    /** Server stuff * /
    private static final HashMap<Remote, Caplist> playercaps = new HashMap<Remote, Caplist>(); */
    
    protected String[] capLines()
    {
        StringBuilder toSend = null;
        ArrayList<String> linebuilder = new ArrayList<String>();
        for (Capability c:caplist.capabilities.values())
        {
            String curCap = c.toString();
            if(toSend == null)
            {
                toSend = new StringBuilder(prefix);
                if (toSend.length() + curCap.length() > maxLength)
                    throw new RuntimeException("Impossibly long capability error");
                toSend.append(curCap);
                continue;
            }
            else if(toSend.length() + curCap.length() + 1 > maxLength)
            {
                System.out.println("Sending "+toSend.length()+": "+toSend.toString());
                linebuilder.add(toSend.toString());
                toSend=null;
            }
            else
            {
                toSend.append(" "+curCap);
            }
        }
        if (toSend != null)
        {
            System.out.println("Sending: "+toSend.toString());
            linebuilder.add(toSend.toString());
        }
        linebuilder.add(doneprefix+"done");
        return linebuilder.toArray(new String[0]);
    }

    protected void _registerCap(Capability c)
    {
        caplist.capabilities.put(c.type+c.name, c);
    }

    protected void _registerCap(String strc)
    {
        Capability c = new Capability(strc);
        caplist.capabilities.put(c.type+c.name, c);
    }

    protected void _unregisterCap(Capability c)
    {
        caplist.capabilities.remove(c.type+c.name);
    }

    protected void _unregisterCap(String c)
    {
        caplist.capabilities.remove(c);
    }
    /*
    public boolean hasCap(Remote p, String c)
    {
        if(p == server)
            return serverCaplist != null && serverCaplist.capabilities.containsKey(c);
        else
            return playercaps.get(p) != null && playercaps.get(p).capabilities.containsKey(c);
    }

    public static boolean hasCap(Remote p, Capability c)
    {
        if(p == server)
            return serverCaplist != null && serverCaplist.capabilities.containsKey(c.type+c.name);
        else
            return playercaps.get(p) != null && playercaps.get(p).capabilities.containsKey(c.type+c.name);
    }

    public static Capability getCap(Remote p, String c)
    {
        if(p == server)
            return serverCaplist != null ? serverCaplist.capabilities.get(c) : null;
        else
            return playercaps.get(p) != null ? playercaps.get(p).capabilities.get(c) : null;
    }

    public static Caplist getCapList(Remote p)
    {
        if(p == server)
            return serverCaplist;
        else
            return playercaps.get(p);
    }

    
    /**
     * Add a capability that was sent by the remote
     * @param cap
     * /
    public static void _addCap(Remote r, String cap)
    {
        Matcher match = cappattern.matcher(cap);
        if (!match.matches())
            throw new RuntimeException("String is not a capability: "+cap);
        String type = match.group(1);
        String name = match.group(2);
        String args = match.group(3);
        if(r == server)
        { // We're on the client
            serverCaplist.capabilities.put(type+name, new Capability(type, name, args));
        }
        else
        {
            Caplist list = playercaps.get(r);
            if (list == null)
            {
                if (!type.equals("v"))
                {
                    System.err.println("Capability is not version-type: "+cap);
                    return;
                }
                list = new Caplist(Integer.parseInt(name), r.getName());
                playercaps.put(r, list);
            }
            else
            {
                list.capabilities.put(type+name, new Capability(type, name, args));
            }
        }
    }

    /** server use * /
    public static void clearCaps(Remote r)
    {
        playercaps.remove(r);
    }

    /** when client has recieved initialization from server * /
    public static void _initCaps(int version)
    {
        serverCaplist = new Caplist(version);
        capableServer = true;
        sendCaps(server);
    }

    /** when client has disconnected from server - client use * /
    public static void _disconnected()
    {
        serverCaplist = null;
        server = null;
        connected = false;
        capableServer = false;
    }

    /** when client has just connected to a server - client use * /
    public static void _connectedToServer(Remote r)
    {
        server = r;
        connected = true;
        capableServer = false;
        serverCaplist = null;
    } */
}
