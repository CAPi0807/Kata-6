package software.ulpgc.katas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram {
    private final Map<String, Integer> histogram = new HashMap<>();
    public Set<String> keys(){
        return histogram.keySet();
    }

    public int valueOf(String key){
        return histogram.getOrDefault(key, 0);
    }

    public void feed(String key){
        histogram.put(key, valueOf(key) + 1);
    }
}
