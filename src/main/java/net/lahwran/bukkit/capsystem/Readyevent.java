/**
 * 
 */
package net.lahwran.bukkit.capsystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;


/**
 * @author lahwran
 *
 */
@SuppressWarnings("serial")
public final class Readyevent extends Event {
    private final Player player;
    protected Readyevent(Player p)
    {
        super("CommReadyevent");
        player = p;
    }
    public Player getPlayer()
    {
        return player;
    }
}
