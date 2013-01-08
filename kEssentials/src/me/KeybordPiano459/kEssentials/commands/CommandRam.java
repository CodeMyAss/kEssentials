package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRam extends kCommand implements CommandExecutor {
    public CommandRam(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ram")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.ram")) {
                        player.sendMessage(GREEN + "Free RAM: " + plugin.getRAM().getFreeRAM() + "MB");
                        player.sendMessage(GREEN + "Max RAM: " + plugin.getRAM().getMaxRAM() + "MB");
                        player.sendMessage(GREEN + "Used RAM: " + plugin.getRAM().getUsedRAM() + "MB");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/ram");
                }
            } else {
                if (args.length == 0) {
                    log(Level.INFO, "Free RAM: " + plugin.getRAM().getFreeRAM() + "MB");
                    log(Level.INFO, "Max RAM: " + plugin.getRAM().getMaxRAM() + "MB");
                    log(Level.INFO, "Used RAM: " + plugin.getRAM().getUsedRAM() + "MB");
                } else {
                    incorrectUsageC("/ram");
                }
            }
        }
        return false;
    }
}