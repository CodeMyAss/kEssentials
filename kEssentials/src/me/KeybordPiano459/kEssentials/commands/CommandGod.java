package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGod extends kCommand implements CommandExecutor {
    public CommandGod(kEssentials plugin) {
        super(plugin);
    }
    
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")) {
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
        }
        return false;
    }
}
