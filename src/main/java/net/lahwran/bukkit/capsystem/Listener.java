package net.lahwran.bukkit.capsystem;

import net.lahwran.capsystem.Capability;
import net.lahwran.capsystem.Capsystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class Listener extends PlayerListener implements CommandExecutor
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

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        //Ask client to tell about themselves
        Player player = event.getPlayer();
        player.sendRawMessage(prefix + colorEncode(Capsystem.protocolVersion));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split)
    {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You're not a player!");
            return true;
        }
        System.out.print(command.getName());
        if (command.getName().equals("@caps"))
        {
            for (String s:split)
            {
                Capsystem.addCap((Player)sender, s);
            }
        }
        else if (command.getName().equals("@cap"))
        {
            if (split.length > 0 && split[0].equals("done"))
            {
                Capsystem.sendServerCaps(prefix, (Player)sender);
            }
        }
        else if (command.getName().equals("@comm"))
        {
            
        }
        return true;
    }
}
