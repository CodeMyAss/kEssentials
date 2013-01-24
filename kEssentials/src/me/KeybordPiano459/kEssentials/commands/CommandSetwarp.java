package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandSetwarp extends kCommand {
    public CommandSetwarp(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("kessentials.setwarp")) {
                    Location loc = player.getLocation();
                    String name = args[0];
                    String world = player.getWorld().getName();
                    int x = loc.getBlockX();
                    int y = loc.getBlockY();
                    int z = loc.getBlockZ();
                    float yaw = loc.getYaw();
                    float pitch = loc.getPitch();
                    FileConfiguration wconfig = plugin.getWarps().getWarpsConfig();
                    wconfig.set("warps." + name + ".x", x);
                    wconfig.set("warps." + name + ".y", y);
                    wconfig.set("warps." + name + ".z", z);
                    wconfig.set("warps." + name + ".yaw", yaw);
                    wconfig.set("warps." + name + ".pitch", pitch);
                    wconfig.set("warps." + name + ".world", world);
                    plugin.getWarps().saveWarpsConfig();
                    plugin.getWarps().reloadWarpsConfig();
                    player.sendMessage(GREEN + "You have sucessfully set a warp!");
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/setwarp <name>");
            }
        } else {
            consoleError();
        }
        return false;
    }
}
