package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandDelwarp extends kCommand {
    public CommandDelwarp(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("kessentials.delwarp")) {
                    ConfigurationSection warp = plugin.getWarps().getWarpsConfig().getConfigurationSection("warps." + args[0]);
                    if (warp != null) {
                        FileConfiguration wconfig = plugin.getWarps().getWarpsConfig();
                        wconfig.set("warps." + args[0], null);
                        plugin.getWarps().saveWarpsConfig();
                        player.sendMessage(GREEN + "You have sucessfully deleted a warp!");
                    } else {
                        player.sendMessage(RED + "That warp doesn't exist!");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/delwarp <name>");
            }
        } else {
            consoleError();
        }
        return false;
    }
}