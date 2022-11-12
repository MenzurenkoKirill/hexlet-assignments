package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> result = new HashMap<>();
        if (text.equals("")) {
            return  result;
        }
        String[] arrayText = text.split(" ");
        for (String word : arrayText) {
            if (result.containsKey(word)) {
                int i = result.get(word);
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }
    public static String toString(Map<String, Integer> result) {
        if (result.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (Map.Entry<String, Integer> lib : result.entrySet()) {
            stringBuilder.append("  " + lib.getKey() + ": " + lib.getValue() + "\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
//END
