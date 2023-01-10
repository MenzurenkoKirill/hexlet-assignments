package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> listImmovables, int countToPrint) {
        List<String> list = listImmovables.stream()
                .sorted((a1, a2) -> a1.compareTo(a2))
                .limit(countToPrint)
                .map(x -> x.toString())
                .collect(Collectors.toList());
        return list;
    }
}
// END
