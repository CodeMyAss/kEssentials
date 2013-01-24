package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGod extends kCommand {
    public CommandGod(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.god")) {
                    if (plugin.getGod().godmode.contains(player.getName())) {
                        plugin.getGod().godmode.remove(player.getName());
                    } else {
                        plugin.getGod().godmode.add(player.getName());
                    }
                    player.sendMessage(GREEN + "You now have godmode " + (plugin.getGod().godmode.contains(player.getName()) ? "enabled!" : "disabled."));
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/god");
            }
        } else {
            consoleError();
        }
        return false;
    }
}
