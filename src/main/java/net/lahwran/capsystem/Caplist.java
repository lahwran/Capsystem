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
    public Caplist(int version, String name)
    {
        this.version = version;
        this.name = name;
    }

    public Caplist(int version)
    {
        this.version = version;
        this.name = null;
    }
}
