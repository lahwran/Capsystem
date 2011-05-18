/**
 * 
 */
package net.lahwran.mcclient.capsystem;

import net.lahwran.capsystem.commdata.Commdata;

/**
 * @author lahwran
 *
 */
public final class Commevent {
    @SuppressWarnings("unchecked") private final Commdata[] data;
    
    @SuppressWarnings("unchecked")
    protected Commevent(Commdata[] data)
    {
        this.data = data;
    }

    public int getArgCount()
    {
        return data.length;
    }
    
    @SuppressWarnings("unchecked")
    public Commdata getData(int index)
    {
        return data[index];
    }
}
