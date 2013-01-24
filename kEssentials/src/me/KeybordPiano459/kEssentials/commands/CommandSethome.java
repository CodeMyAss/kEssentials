package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.config.PlayerConfig;
import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.players.kPlayer;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandSethome extends kCommand {
    public CommandSethome(kEssentials plugin) {
        super(plugin);
    }
    
    String name;
    private PlayerConfig pc = new PlayerConfig(plugin, name);

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.sethome")) {
                    kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
                    FileConfiguration config = kplayer.getPlayerConfig().getConfig();
                    name = player.getName();
                    Location loc = player.getLocation();
                    config.set("home.world", loc.getWorld().getName());
                    config.set("home.x", loc.getX());
                    config.set("home.y", loc.getY());
                    config.set("home.z", loc.getZ());
                    config.set("home.yaw", loc.getYaw());
                    config.set("home.pitch", loc.getPitch());
                    kplayer.getPlayerConfig().savePlayerConfig();
                    player.sendMessage(GREEN + "Your home has been set!");
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/sethome");
            }
        } else {
            consoleError();
        }
        return false;
    }
}