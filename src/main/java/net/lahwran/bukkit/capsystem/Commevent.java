/**
 * 
 */
package net.lahwran.bukkit.capsystem;

import net.lahwran.capsystem.commdata.Commdata;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;


/**
 * @author lahwran
 *
 */
@SuppressWarnings("serial")
public final class Commevent extends Event {
    @SuppressWarnings("unchecked")
    private final Commdata[] data;
    private final Player player;
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    public Commdata getData(int index)
    {
        return data[index];
    }
    public Player getPlayer()
    {
        return player;
    }
}
