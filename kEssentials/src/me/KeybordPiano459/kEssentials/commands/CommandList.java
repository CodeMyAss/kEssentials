package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandList extends kCommand {
    public CommandList(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kessentials.list")) {
                Player[] players = Bukkit.getServer().getOnlinePlayers();
                if (args.length == 0) {
                    String liststr = "";
                    for (Player p : players) {
                        liststr += p.getDisplayName() + ", ";
                    }
                    
                    player.sendMessage(liststr);
                } else {
                    incorrectUsage(player, "/list");
                }
            } else {
                noPermissionsMessage(player);
            }
        } else {
            Player[] players = Bukkit.getServer().getOnlinePlayers();
            if (args.length == 0) {
                String liststr = "";
                for (Player p : players) {
                    liststr += p.getDisplayName() + ", ";
                }
                
                log(Level.INFO, liststr);
            } else {
                incorrectUsageC("/list");
            }
        }
        return false;
    }
}
