package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKillall extends kCommand {
    public CommandKillall(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.killall")) {
                    player.sendMessage(GREEN + "You have murdered everybody!");
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        if (p != player) {
                            p.setHealth(0);
                            p.sendMessage(DARK_GRAY + "You have been murdered.");
                        }
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/killall");
            }
        } else {
            if (args.length == 0) {
                log(Level.INFO, "You have murdered everybody!");
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.setHealth(0);
                    p.sendMessage(DARK_GRAY + "You have been murdered.");
                }
            } else {
                incorrectUsageC("/killall");
            }
        }
        return false;
    }
}