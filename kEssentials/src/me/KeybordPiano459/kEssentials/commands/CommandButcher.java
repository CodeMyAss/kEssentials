package me.KeybordPiano459.kEssentials.commands;

import java.util.List;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class CommandButcher extends kCommand {
    public CommandButcher(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.butcher")) {
                    int amount = 0;
                    List<Entity> entitylist = player.getNearbyEntities((double)100, (double)100, (double)100);
                    for (Entity entity : entitylist) {
                        if (entity instanceof Monster) {
                            amount++;
                            entity.remove();
                        }
                    }
                    player.sendMessage(GREEN + "" + amount + " mobs have been killed.");
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/butcher");
            }
        } else {
            consoleError();
        }
        return false;
    }
}
