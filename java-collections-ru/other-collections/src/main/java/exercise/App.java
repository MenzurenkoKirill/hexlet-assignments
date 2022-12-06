package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App{
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> dictionary1, Map<String, Object> dictionary2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> item1 : dictionary1.entrySet()) {
            if (dictionary2.containsKey(item1.getKey())) {
                if (dictionary2.get(item1.getKey()).equals(item1.getValue())) {
                    result.put(item1.getKey(), "unchanged");
                } else result.put(item1.getKey(), "changed");
            } else result.put(item1.getKey(), "deleted");
        }
        for (Map.Entry<String, Object> item2 : dictionary2.entrySet()) {
            if (!(result.containsKey(item2.getKey()))) {
                result.put(item2.getKey(), "added");
            }
        }
        return result;
    }
}
//END
