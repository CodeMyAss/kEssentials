package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.God;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUngod extends kCommand implements CommandExecutor {
    public CommandUngod(kEssentials plugin) {
        super(plugin);
    }
    
    private God god;
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ungod")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.ungod")) {
                        god.godmode.put(player.getName(), false);
                        player.sendMessage(GREEN + "You now have god mode disabled.");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/ungod");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}