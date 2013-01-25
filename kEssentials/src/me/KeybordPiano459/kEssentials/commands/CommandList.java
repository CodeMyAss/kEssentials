package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandList extends kCommand {
    public CommandList(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        Player[] players = Bukkit.getServer().getOnlinePlayers();
        if (args.length == 0) {
            String liststr = "";
            for (Player p : players) {
                liststr += p.getDisplayName() + ", ";
            }
            
            if (sender instanceof Player) ((Player)sender).sendMessage(liststr);
            else log(Level.INFO, liststr);
        } else {
            if (sender instanceof Player) incorrectUsage(((Player)sender), "/list");
            else incorrectUsageC("/list");
        }
        return false;
    }
}
