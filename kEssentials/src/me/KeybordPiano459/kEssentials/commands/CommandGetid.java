package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGetid extends kCommand {
    public CommandGetid(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.getid")) {
                    int id = player.getItemInHand().getTypeId();
                    player.sendMessage(GREEN + "The ID of the item you're holding is " + id);
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/getid");
            }
        } else {
            consoleError();
        }
        return false;
    }
}