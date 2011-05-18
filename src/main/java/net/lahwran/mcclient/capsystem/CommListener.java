/**
 * 
 */
package net.lahwran.mcclient.capsystem;

import net.lahwran.capsystem.commdata.Commdata;

/**
 * Half-assed listener/callback/hook/whatever thingy
 * @author lahwran
 *
 */
public abstract class CommListener {
    @SuppressWarnings("unchecked")
    public abstract void onCommevent(Commdata[] data);
    public void onConnect(){};
}
