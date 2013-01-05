package me.KeybordPiano459.kEssentials.commands;

import java.util.HashSet;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly extends kCommand implements CommandExecutor {
    public CommandFly(kEssentials plugin) {
        super(plugin);
    }
    
    public HashSet<String> flymode = new HashSet<String>();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.fly")) {
                        player.setAllowFlight(true);
                        if (flymode.contains(player.getName())) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            flymode.remove(player.getName());
                        } else {
                            flymode.add(player.getName());
                            player.setFlying(true);
                        }
                        player.sendMessage(GREEN + "You now have flymode " + (flymode.contains(player.getName()) ? "enabled!" : "disabled."));
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/fly");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}