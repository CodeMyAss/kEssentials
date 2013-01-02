package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSun extends kCommand implements CommandExecutor {
    public CommandSun(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sun")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("kessentials.sun")) {
                    if (args.length == 0) {
                        World world = player.getWorld();
                        world.setStorm(false);
                        player.sendMessage(GREEN + "It is now sunny in the world " + YELLOW + world.getName());
                    } else if (args.length == 1) {
                        World world = Bukkit.getServer().getWorld(args[0]);
                        if (world != null) {
                            world.setTime(0);
                            player.sendMessage(GREEN + "It is now sunny in the world " + YELLOW + world.getName());
                        } else {
                            player.sendMessage(RED + "The world " + YELLOW + args[0] + RED + " is nonexistant.");
                        }
                    } else {
                        incorrectUsage(player, "/sun [world]");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                if (args.length == 1) {
                    World world = Bukkit.getServer().getWorld(args[0]);
                    if (world != null) {
                        world.setStorm(false);
                        log(Level.INFO, "It is now sunny in the world " + world.getName());
                    } else {
                        log(Level.INFO, "The world " + args[0] + " is nonexistant.");
                    }
                } else {
                    incorrectUsageC("/sun <world>");
                }
            }
        }
        return false;
    }
}