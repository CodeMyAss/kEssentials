package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMute extends kCommand {
    public CommandMute(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("kessentials.mute")) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (plugin.getPlayerManager().playerExists(args[0])) {
                        plugin.mute.setMute(player, true);
                        player.sendMessage(GREEN + "You have muted " + args[0] + "!");
                        if (tplayer != null) {
                            tplayer.sendMessage(DARK_GRAY + "You have been muted!");
                        }
                    } else {
                        player.sendMessage(RED + args[0] + " has never played on this server.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/mute <player>");
            }
        } else {
            if (args.length == 1) {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                plugin.mute.setMute(player, true);
                log(Level.INFO, "You have muted " + args[0]);
                if (player != null) {
                    player.sendMessage(DARK_GRAY + "You have been muted!");
                }
            } else {
                incorrectUsageC("/mute <player>");
            }
        }
        return false;
    }
}