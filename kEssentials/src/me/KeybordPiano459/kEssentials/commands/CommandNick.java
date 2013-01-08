package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.Nickname;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandNick extends kCommand implements CommandExecutor {
    public CommandNick(kEssentials plugin) {
        super(plugin);
    }
    
    private Nickname nickname = plugin.getNick();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("nick")) {
            Player player = (Player) sender;
            String name = player.getName();
            FileConfiguration pconfig = plugin.getPlayerManager().getPlayer(name).getPlayerConfig().getConfig();
            if (args.length == 0) {
                if (player.hasPermission("kessentials.nick")) {
                    player.sendMessage(GREEN + "Your name is now " + name);
                    player.setDisplayName(name);
                    pconfig.set("nickname", name);
                    nickname.setNickName(name, name);
                } else {
                    noPermissionsMessage(player);
                }
            } else if (args.length == 1) {
                if (player.hasPermission("kessentials.nick")) {
                    player.sendMessage(GREEN + "Your name is now " + args[0]);
                    player.setDisplayName(name);
                    pconfig.set("nickname", args[0]);
                    nickname.setNickName(name, args[0]);
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/nick [name]");
            }
        }
        return false;
    }
}