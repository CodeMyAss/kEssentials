package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKickall extends kCommand implements CommandExecutor {
    public CommandKickall(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kickall")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.kickall")) {
                        player.sendMessage(GREEN + "You have kicked everybody!");
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            if (p != player) {
                                p.kickPlayer("You have been kicked!");
                            }
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/kickall");
                }
            } else {
                if (args.length == 0) {
                    log(Level.INFO, "You have kicked everybody!");
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.kickPlayer("You have been kicked!");
                    }
                } else {
                    incorrectUsageC("/kickall");
                }
            }
        }
        return false;
    }
}