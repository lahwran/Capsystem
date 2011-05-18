/**
 * 
 */
package net.lahwran.capsystem;

/**
 * Half-assed listener/callback/hook/whatever thingy
 * @author lahwran
 *
 */
public abstract class CommeventListener {
    public abstract void onCommevent(Commevent e);
    public void onConnect(){};
}
