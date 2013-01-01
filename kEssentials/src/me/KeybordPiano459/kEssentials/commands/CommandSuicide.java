package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSuicide extends kCommand implements CommandExecutor {
    public CommandSuicide(kEssentials plugin) {
        super(plugin);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("suicide")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.suicide")) {
                        player.setHealth(0);
                        player.sendMessage(GREEN + "You are now dead! Yaay!");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/suicide");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}
