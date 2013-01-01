package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.helpers.TPS;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTPS extends kCommand implements CommandExecutor {
    public CommandTPS(kEssentials plugin) {
        super(plugin);
    }
    
    private TPS tps;
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tps")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.tps")) {
                        player.sendMessage(GREEN + "Current server TPS: " + tps.getServerTPS());
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/tps");
                }
            } else {
                if (args.length == 0) {
                    log(Level.INFO, "Current server TPS: " + tps.getServerTPS());
                } else {
                    incorrectUsageC("/tps");
                }
            }
        }
        return false;
    }
}