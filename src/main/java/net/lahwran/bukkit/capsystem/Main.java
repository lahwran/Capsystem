
package net.lahwran.bukkit.capsystem;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public final Listener listener = new Listener(this);
    public static final int protocolVersion = 0;

    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_JOIN, listener, Priority.Lowest, this);
        getCommand("@caps").setExecutor(listener);
    }
    public void onDisable() {}

}
