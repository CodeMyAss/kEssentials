package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPlatform extends kCommand {
    public CommandPlatform(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kessentials.platform")) {
                if (args.length == 0) {
                    Location loc = player.getLocation();
                    World world = player.getWorld();
                    double x = loc.getX();
                    double y = loc.getY();
                    double z = loc.getZ();
                    Location platformloc = new Location(world, x, y-1, z);
                    Block block = player.getWorld().getBlockAt(platformloc);
                    block.setType(Material.GLASS);
                    player.sendMessage(GREEN + "Platform has been placed.");
                } else {
                    incorrectUsage(player, "/platform");
                }
            } else {
                noPermissionsMessage(player);
            }
        } else {
            consoleError();
        }
        return false;
    }
}
