
package net.lahwran.bukkit.capsystem;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public final Listener listener = new Listener(this);

    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_JOIN, listener, Priority.Lowest, this);
        getCommand("@caps").setExecutor(listener);
        getCommand("@cap").setExecutor(listener);
        getCommand("@comm").setExecutor(listener);
        
        //this is hacky - init the static stuff in capsystem and commsystem in case it hasn't been
        Commsystem.instance.equals(null);
        Capsystem.instance.equals(null);
    }
    public void onDisable() {}

}
