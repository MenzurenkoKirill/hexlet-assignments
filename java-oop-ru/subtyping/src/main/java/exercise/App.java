package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (Map.Entry<String, String> element : storage.toMap().entrySet()) {
            storage.unset(element.getKey());
            storage.set(element.getValue(), element.getKey());
        }
    }
}
// END
