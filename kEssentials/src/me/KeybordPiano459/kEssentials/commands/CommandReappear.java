package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReappear extends kCommand {
    public CommandReappear(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.reappear")) {
                    player.sendMessage(GREEN + "You are no longer invisible.");
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.showPlayer(player);
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/reappear");
            }
        } else {
            consoleError();
        }
        return false;
    }
}