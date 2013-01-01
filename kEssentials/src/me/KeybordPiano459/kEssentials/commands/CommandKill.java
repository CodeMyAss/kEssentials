package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKill extends kCommand implements CommandExecutor {
    public CommandKill(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kill")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (player.hasPermission("kessentials.kill")) {
                        Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                        if (tplayer != null) {
                            tplayer.setHealth(0);
                            tplayer.sendMessage(DARK_GRAY + "You have been murdered.");
                            player.sendMessage(GREEN + "You have murdered " + tplayer.getName());
                        } else {
                            player.sendMessage(RED + args[0] + " isn't currently online.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/kill <player>");
                }
            } else {
                if (args.length == 1) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        tplayer.setHealth(0);
                        tplayer.sendMessage(DARK_GRAY + "You have been murdered.");
                        log(Level.INFO, "You have murdered " + tplayer.getName());
                    } else {
                        log(Level.INFO, args[0] + " isn't currently online.");
                    }
                } else {
                    incorrectUsageC("/kill <player>");
                }
            }
        }
        return false;
    }
}