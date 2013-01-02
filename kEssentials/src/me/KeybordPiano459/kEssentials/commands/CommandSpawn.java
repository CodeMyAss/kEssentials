package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.Spawn;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandSpawn extends kCommand implements CommandExecutor {
    public CommandSpawn(kEssentials plugin) {
        super(plugin);
    }
    
    private Spawn spawn = new Spawn(plugin);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.spawn")) {
                        if (spawn.getSpawnConfig().getString("spawn.world") != null) {
                            FileConfiguration sconfig = spawn.getSpawnConfig();
                            int x = sconfig.getInt("spawn.x");
                            int y = sconfig.getInt("spawn.y");
                            int z = sconfig.getInt("spawn.z");
                            float yaw = sconfig.getInt("spawn.yaw");
                            float pitch = sconfig.getInt("spawn.pitch");
                            String world = sconfig.getString("spawn.world");
                            World spawnworld = Bukkit.getServer().getWorld(world);
                            Location thespawn = new Location(spawnworld, x, y, z, yaw, pitch);
                            player.teleport(thespawn);
                            player.sendMessage(GREEN + "You have teleported to the spawn.");
                        } else {
                            player.sendMessage(RED + "The spawn hasn't been set yet.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/spawn");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}