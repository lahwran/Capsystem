/**
 * 
 */
package net.lahwran.capsystem;

import net.lahwran.capsystem.commdata.Commdata;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;


/**
 * @author lahwran
 *
 */
public final class Commevent extends Event {
    private final Commdata[] data;
    private final Player player;
    /**
     * @param p 
     * @param name
     */
    protected Commevent(Player p, Commdata[] data)
    {
        super("Commevent");
        this.data = data;
        this.player = p;
    }

    public int getArgCount()
    {
        return data.length;
    }
    public Commdata getData(int index)
    {
        return data[index];
    }
    public Player getPlayer()
    {
        return player;
    }
}
