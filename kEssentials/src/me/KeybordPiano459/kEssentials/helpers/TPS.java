package me.KeybordPiano459.kEssentials.helpers;

import java.util.LinkedList;

public class TPS {
    private final transient LinkedList<Float> past = new LinkedList<Float>();
    public float getServerTPS() {
        float average = 0;
        for (Float f : past) {
            if (f != null) {
                average += f;
            }
        }
        float tps = average / past.size();
        return tps;
    }
}
