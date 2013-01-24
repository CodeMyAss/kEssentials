package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandItemname extends kCommand {
    public CommandItemname(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                if (player.hasPermission("kessentials.itemname")) {
                    StringBuilder str = new StringBuilder(args[0]);
                    for(int i=1; i<args.length; i++){
                        str.append(" ").append(args[i]);
                    }
                    String name = ChatColor.translateAlternateColorCodes('&', str.toString());
                    if (player.getItemInHand().getType() != Material.AIR) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(name);
                        item.setItemMeta(meta);
                        player.sendMessage(GREEN + "Your item is now named " + name + ".");
                    } else {
                        player.sendMessage(RED + "You need to be holding an item in your hand.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/itemname <name>");
            }
        } else {
            consoleError();
        }
        return false;
    }
}