/**
 * 
 */
package net.lahwran.capsystem;

import java.util.HashMap;

/**
 * @author lahwran
 *
 */
public class Caplist {
    public final int version;
    public final HashMap<String, Capability> capabilities = new HashMap<String, Capability>();
    public final String name;
    /**
     * For caplists that represent client capabilities, used from serverside
     * @param version protocol version
     * @param name player name represented
     */
    public Caplist(int version, String name)
    {
        this.version = version;
        this.name = name;
    }

    /**
     * For local representation of this processes's capabilities, 
     * and for representation of the server's on the clientside
     * @param version protocol version
     */
    public Caplist(int version)
    {
        this.version = version;
        this.name = null;
    }
}
