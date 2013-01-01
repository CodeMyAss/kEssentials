package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.God;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGod extends kCommand implements CommandExecutor {
    public CommandGod(kEssentials plugin) {
        super(plugin);
    }
    
    private God god;
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.god")) {
                        god.godmode.put(player.getName(), true);
                        player.sendMessage(GREEN + "You now have god mode enabled!");
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
