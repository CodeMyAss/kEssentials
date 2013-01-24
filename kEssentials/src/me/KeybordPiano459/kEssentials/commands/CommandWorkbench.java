package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWorkbench extends kCommand {
    public CommandWorkbench(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.workbench")) {
                    player.openWorkbench(null, true);
                    player.sendMessage(GREEN + "You now have a crafting table!");
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/workbench");
            }
        } else {
            consoleError();
        }
        return false;
    }
}