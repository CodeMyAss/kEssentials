package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSuicide extends kCommand {
    public CommandSuicide(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
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
        return false;
    }
}
