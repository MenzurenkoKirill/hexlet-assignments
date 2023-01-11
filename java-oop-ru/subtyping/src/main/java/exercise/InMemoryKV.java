package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private Map<String, String> baseKeysOrValues = new HashMap<>();
    InMemoryKV(Map<String, String> baseKeysOrValues) {
        this.baseKeysOrValues.putAll(baseKeysOrValues);
    }
    @Override
    public void set(String key, String value) {
        baseKeysOrValues.put(key, value);
    }
    @Override
    public void unset(String key) {
        baseKeysOrValues.remove(key);
    }
    @Override
    public String get(String key, String defaultValue) {
        return baseKeysOrValues.getOrDefault(key, defaultValue);
    }
    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(baseKeysOrValues);
    }
}
// END
