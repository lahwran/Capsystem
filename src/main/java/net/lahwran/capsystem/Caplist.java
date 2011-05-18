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

    public Caplist(int version)
    {
        this.version = version;
    }
}
