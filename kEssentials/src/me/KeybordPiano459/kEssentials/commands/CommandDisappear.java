package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import net.minecraft.server.v1_4_6.EntityPlayer;
import net.minecraft.server.v1_4_6.Packet201PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_4_6.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class CommandDisappear extends kCommand implements CommandExecutor {
    public CommandDisappear(kEssentials plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("disappear")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.disappear")) {
                        player.sendMessage(GREEN + "You are now invisible.");
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            p.hidePlayer(player);
                            CraftPlayer cp = (CraftPlayer) p;
                            EntityPlayer target = cp.getHandle();
                            target.playerConnection.sendPacket(new Packet201PlayerInfo(player.getPlayerListName(), true, target.ping));
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/disappear");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}