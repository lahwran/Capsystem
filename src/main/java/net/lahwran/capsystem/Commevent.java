/**
 * 
 */
package net.lahwran.capsystem;

import net.lahwran.capsystem.commdata.Commdata;


/**
 * @author lahwran
 *
 */
public final class Commevent {
    private final Commdata[] data;
    protected Commevent(Commdata[] data)
    {
        this.data = data;
    }

    public int getArgCount()
    {
        return data.length;
    }
    public Commdata getData(int index)
    {
        return data[index];
    }
}
