package me.KeybordPiano459.kEssentials.commands;

import java.util.List;
import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWorldinfo extends kCommand {
    public CommandWorldinfo(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.performCommand("worldinfo " + player.getWorld().getName());
            } else if (args.length == 1) {
                if (player.hasPermission("kessentials.worldinfo")) {
                    World world = Bukkit.getServer().getWorld(args[0]);
                    if (world != null) {
                        player.sendMessage("---------- [" + AQUA + "WorldInfo" + RESET + "] -----------");
                        player.sendMessage(GREEN + "World Name: " + DARK_GREEN + world.getName());
                        player.sendMessage(GREEN + "Time: " + DARK_GREEN + world.getTime() + "/24000");
                        player.sendMessage(GREEN + "Difficulty: " + DARK_GREEN + world.getDifficulty());
                        player.sendMessage(GREEN + "World Generator: " + DARK_GREEN + world.getGenerator());
                        player.sendMessage(GREEN + "Seed: " + DARK_GREEN + world.getSeed());
                        player.sendMessage(GREEN + "Number of Players: " + getWorldPlayersAmount(world));
                        player.sendMessage(GREEN + "Weather: " + getWeatherOfWorld(world));
                        player.sendMessage("----------------------------------");
                    } else {
                        player.sendMessage(RED + "That world doesn't exist!");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/worldinfo [world]");
            }
        } else {
            if (args.length == 1) {
                World world = Bukkit.getServer().getWorld(args[0]);
                if (world != null) {
                    log(Level.INFO, "---------- [WorldInfo] -----------");
                    log(Level.INFO, "World Name: " + world.getName());
                    log(Level.INFO, "Time: " + world.getTime() + "/24000");
                    log(Level.INFO, "Difficulty: " + world.getDifficulty());
                    log(Level.INFO, "World Generator: " + world.getGenerator());
                    log(Level.INFO, "Seed: " + world.getSeed());
                    log(Level.INFO, "Number of Players: " + getWorldPlayersAmount(world));
                    log(Level.INFO, "Weather: " + getWeatherOfWorld(world));
                    log(Level.INFO, "----------------------------------");
                } else {
                    log(Level.INFO, "That world doesn't exist!");
                }
            } else {
                incorrectUsageC("/worldinfo <world>");
            }
        }
        return false;
    }

    private int getWorldPlayersAmount(World world) {
        int playeramt = 0;
        List<Player> players = world.getPlayers();
        for (Player player : players) {
            playeramt++;
        }
        return playeramt;
    }

    private String getWeatherOfWorld(World world) {
        String weathertype = "Sunny";
        if (world.hasStorm()) {
            weathertype = "Rainy";
        }
        return weathertype;
    }
}
