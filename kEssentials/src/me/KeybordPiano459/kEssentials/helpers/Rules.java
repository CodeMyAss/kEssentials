package me.KeybordPiano459.kEssentials.helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.event.Listener;

public class Rules extends kHelper implements Listener {
    public Rules(kEssentials plugin) {
        super(plugin);
    }
    
    private File rulesFile = null;
    
    public void createRules() {
        if (rulesFile == null) {
            rulesFile = new File(plugin.getDataFolder(), "rules.txt");
            try {
                rulesFile.createNewFile();
                FileWriter writer = new FileWriter(rulesFile);
                writer.write("1. &2Respect all other players\n");
                writer.write("2. &2Don't grief\n");
                writer.write("3. &2Don't use any hacks that give you an advantage");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}