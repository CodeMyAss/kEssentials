package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTPS extends kCommand {
    public CommandTPS(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.tps")) {
                    player.sendMessage(GREEN + "Current server TPS: " + plugin.getTPS().getServerTPS());
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/tps");
            }
        } else {
            if (args.length == 0) {
                log(Level.INFO, "Current server TPS: " + plugin.getTPS().getServerTPS());
            } else {
                incorrectUsageC("/tps");
            }
        }
        return false;
    }
}