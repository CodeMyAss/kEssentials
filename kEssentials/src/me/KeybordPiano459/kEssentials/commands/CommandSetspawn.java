package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.Spawn;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandSetspawn extends kCommand implements CommandExecutor {
    public CommandSetspawn(kEssentials plugin) {
        super(plugin);
    }
    
    private Spawn spawn = new Spawn(plugin);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.setspawn")) {
                        Location loc = player.getLocation();
                        String world = player.getWorld().getName();
                        int x = loc.getBlockX();
                        int y = loc.getBlockY();
                        int z = loc.getBlockZ();
                        float yaw = loc.getYaw();
                        float pitch = loc.getPitch();
                        FileConfiguration sconfig = spawn.getSpawnConfig();
                        sconfig.set("spawn.x", x);
                        sconfig.set("spawn.y", y);
                        sconfig.set("spawn.z", z);
                        sconfig.set("spawn.yaw", yaw);
                        sconfig.set("spawn.pitch", pitch);
                        sconfig.set("spawn.world", world);
                        spawn.saveSpawnConfig();
                        player.sendMessage(GREEN + "You have sucessfully set the spawn!");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/setspawn <name>");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}