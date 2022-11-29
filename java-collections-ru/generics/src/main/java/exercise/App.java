package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> criteries) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean check = false;
            for (Map.Entry<String, String> where : criteries.entrySet()) {
                if (book.containsKey(where.getKey())) {
                    if (book.containsValue(where.getValue())) {
                        check = true;

                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
