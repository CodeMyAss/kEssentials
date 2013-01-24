package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearenderchest extends kCommand {
    public CommandClearenderchest(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.clearenderchest.self")) {
                    player.getEnderChest().clear();
                    player.sendMessage(GREEN + "Your enderchest has been cleared.");
                } else {
                    noPermissionsMessage(player);
                }
            } else if (args.length == 1) {
                if (player.hasPermission("kessentials.clearenderchest.others")) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        tplayer.getEnderChest().clear();
                        tplayer.sendMessage(DARK_GRAY + "Your enderchest has been cleared.");
                    } else {
                        player.sendMessage(RED + "The player " + YELLOW + args[0] + RED + " isn't online.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            }
        } else {
            if (args.length == 1) {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                if (player != null) {
                    player.getEnderChest().clear();
                    player.sendMessage(DARK_GRAY + "Your enderchest has been cleared.");
                } else {
                    log(Level.INFO, "The player " + args[0] + " isn't online.");
                }
            } else {
                incorrectUsageC("/clearenderchest <player>");
            }
        }
        return false;
    }
}