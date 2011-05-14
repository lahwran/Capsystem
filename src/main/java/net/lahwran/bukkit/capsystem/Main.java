
package net.lahwran.bukkit.capsystem;

import net.lahwran.capsystem.Capability;
import net.lahwran.capsystem.Capsystem;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public final Listener listener = new Listener(this);

    public void onEnable() {
        Capsystem.registerCap("+experiment1");
        Capsystem.registerCap("+experiment:thing");
        Capsystem.registerCap(new Capability("-", "breakage", "errors"));
        Capsystem.registerCap("+experim1ent:thing");
        Capsystem.registerCap("+expen1ri1ment:thing");
        Capsystem.registerCap("+expe1rniment:thing");
        Capsystem.registerCap("+exper1niment:thing");
        Capsystem.registerCap("+expneri1ment:thing");
        Capsystem.registerCap("+experin1ment:thing");
        Capsystem.registerCap("+expe31riment:thing");
        Capsystem.registerCap("+experi3nment:thing");
        Capsystem.registerCap("+ex3perni1m3ent:thing");
        Capsystem.registerCap("+expen1r3iment:thing");
        Capsystem.registerCap("+experim1ent:thing");
        Capsystem.registerCap("+expe1ri1ment:thing");
        Capsystem.registerCap("+expe1riment:thing");
        Capsystem.registerCap("+exper1iment:thing");
        Capsystem.registerCap("+experi1ment:thing");
        Capsystem.registerCap("+experi1ment:thing");
        Capsystem.registerCap("+expe31riment:thing");
        Capsystem.registerCap("+experi3ment:thing");
        Capsystem.registerCap("+ex3peri1m3ent:thing");
        Capsystem.registerCap("+expe1r3iment:thing");

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_JOIN, listener, Priority.Lowest, this);
        getCommand("@caps").setExecutor(listener);
        getCommand("@cap").setExecutor(listener);
    }
    public void onDisable() {}

}
