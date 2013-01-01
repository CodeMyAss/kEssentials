package me.KeybordPiano459.kEssentials.metrics;

import me.KeybordPiano459.kEssentials.metrics.BukkitMetrics.Graph;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class MetricsGraph {
    
    PluginManager pm = Bukkit.getServer().getPluginManager();
    
    public void addAddonsGraph(BukkitMetrics metrics) {
        Graph graph = metrics.createGraph("Addons Used");
        addPlotter(graph, "kEconomy");
        addPlotter(graph, "kChat");
    }
    
    private void addPlotter(Graph graph, final String name) {
        graph.addPlotter(new BukkitMetrics.Plotter(name) {
            @Override
            public int getValue() {
                if (pm.getPlugin(name) != null) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
}
