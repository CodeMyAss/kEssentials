package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWhois extends kCommand {
    public CommandWhois(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1) {
            if (player.hasPermission("kessentials.whois")) {
                String nick = plugin.getNick().getRealName(args[0]);
                if (nick != null) {
                    player.sendMessage(args[0] + "'s real name is " + nick);
                } else {
                    player.sendMessage(RED + args[0] + " doesn't exist.");
                }
            } else {
                noPermissionsMessage(player);
            }
        } else {
            incorrectUsage(player, "/whois [name]");
        }
        return false;
    }
}