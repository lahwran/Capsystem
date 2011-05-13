package net.lahwran.bukkit.capsystem;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class Listener extends PlayerListener
{

    private static final String colorchar = "\u00a7";
    private static final String prefix = colorchar + "0" + colorchar + "0" + 
                                         colorchar + "0" + colorchar + "0";

    public final Main plugin;

    public Listener(final Main plugin)
    {
        this.plugin = plugin;
    }

    private static final String colorEncode(int v)
    {
        String hex = String.format("%x", v);
        StringBuilder newstring = new StringBuilder();
        for(int i=0; i<hex.length(); i++)
        {
            newstring.append(colorchar+hex.substring(i, i+1));
        }
        return newstring.toString();
    }

    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendRawMessage(prefix + colorEncode(Main.protocolVersion));
    }
}
