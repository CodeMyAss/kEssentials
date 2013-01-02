package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.Warps;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWarplist extends kCommand implements CommandExecutor {
    public CommandWarplist(kEssentials plugin) 
    {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warplist")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.warplist")) {
                        if (plugin.getWarps().getWarpsConfig().getConfigurationSection("warps.") != null) {
                            int amount = 0;
                            player.sendMessage("----- [" + GREEN + "Warps" + RESET + "] -----");
                            for (String warp : plugin.getWarps().getWarpsConfig().getConfigurationSection("warps.").getKeys(false)) {
                                amount++;
                                player.sendMessage(amount + ". " + GREEN + warp);
                                if (amount == 0) {
                                    player.sendMessage(RED + "No warps have been set yet.");
                                }
                            }
                            player.sendMessage("----- [" + GREEN + "Warps" + RESET + "] -----");
                        } else {
                            player.sendMessage(RED + "No warps have been set yet.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/warplist");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}