package me.KeybordPiano459.kEssentials.commands;
 
import java.util.HashMap;
import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
public class CommandHeal extends kCommand {
    public CommandHeal(kEssentials plugin) {
        super(plugin);
    }
    
    public HashMap<String, Long> healcooldown = new HashMap<String, Long>();
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.heal.self")) {
                    long cooldown = healcooldown.containsKey(player.getName()) ? healcooldown.get(player.getName()) : 0;
                    if (cooldown < System.currentTimeMillis() || player.hasPermission("kessentials.heal.bypass")) {
                        player.setHealth(20);
                        player.setFireTicks(0);
                        player.sendMessage(GREEN + "You have healed yourself.");
                        healcooldown.put(player.getName(), System.currentTimeMillis()+plugin.getkConfig().getConfig().getLong("heal-cooldown"));
                    } else {
                            player.sendMessage(RED + "You still need to wait " + ((healcooldown.get(player.getName()) -  System.currentTimeMillis())/1000)+ " seconds before you can use /heal again.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else if (args.length == 1) {
                if (player.hasPermission("kessentials.heal.others")) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        long cooldown = healcooldown.containsKey(player.getName()) ? healcooldown.get(player.getName()) : 0;
                        if (cooldown < System.currentTimeMillis() || player.hasPermission("kessentials.heal.bypass")) {
                            tplayer.setHealth(20);
                            tplayer.setFireTicks(0);
                            tplayer.sendMessage(DARK_GRAY + "You have been healed.");
                            player.sendMessage(GREEN + "You have healed " + tplayer.getName());
                        } else {
                            player.sendMessage(RED + "You still need to wait " + ((healcooldown.get(player.getName()) -  System.currentTimeMillis())/1000)+ " seconds before you can use /heal again.");
                        }
                    } else {
                        player.sendMessage(RED + args[0] + " isn't currently online.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                String usage = player.hasPermission("kessentials.heal.others") ? "/heal [player]" : "/heal";
                incorrectUsage(player, usage);
            }
        } else {
            if (args.length == 1) {
                Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                if (tplayer != null) {
                    tplayer.setHealth(20);
                    tplayer.setFireTicks(0);
                    tplayer.sendMessage(DARK_GRAY + "You have been healed.");
                    log(Level.INFO, "You have healed " + tplayer.getName());
                } else {
                    log(Level.INFO, args[0] + " isn't currently online.");
                }
            } else {
                incorrectUsageC("/heal <player>");
            }
        }
        return false;
    }
}