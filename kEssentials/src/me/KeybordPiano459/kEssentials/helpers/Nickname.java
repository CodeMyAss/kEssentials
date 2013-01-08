package me.KeybordPiano459.kEssentials.helpers;

import java.util.HashMap;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Nickname extends kHelper implements Listener {
    public Nickname(kEssentials plugin) {
        super(plugin);
    }
    
    private HashMap<String, String> nicknames = new HashMap<String, String>();
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();
        FileConfiguration pconfig = plugin.getPlayerManager().getPlayer(name).getPlayerConfig().getConfig();
        if (pconfig.getString("nickname") == null) {
            pconfig.set("nickname", name);
        }
        player.setDisplayName(pconfig.getString("nickname"));
        nicknames.put(player.getName(), pconfig.getString("nickname"));
    }
    
    public String getRealName(String nickname) {
        return nicknames.get(nickname);
    }
    
    public void setNickName(String realname, String nickname) {
        nicknames.put(realname, nickname);
    }
}