package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSeed extends kCommand {
    public CommandSeed(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kessentials.seed")) {
                if (args.length == 0) {
                    World world = player.getWorld();
                    long seed = world.getSeed();
                    player.sendMessage(GREEN + "Your world's seed is " + seed);
                } else if (args.length == 1) {
                    World world = Bukkit.getServer().getWorld(args[0]);
                    if (world != null) {
                        long seed = world.getSeed();
                        player.sendMessage(GREEN + "The world " + args[0] + "'s seed is " + seed);
                    } else {
                        player.sendMessage(RED + "That world doesn't exist!");
                    }
                } else {
                    incorrectUsage(player, "/seed [world]");
                }
            } else {
                noPermissionsMessage(player);
            }
        } else {
            if (args.length == 1) {
                World world = Bukkit.getServer().getWorld(args[0]);
                if (world != null) {
                    long seed = world.getSeed();
                    log(Level.INFO, "The world " + args[0] + "'s seed is " + seed);
                } else {
                    log(Level.INFO, "That world doesn't exist!");
                }
            } else {
                incorrectUsageC("/seed <world>");
            }
        }
        return false;
    }
}
