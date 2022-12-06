package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
/*class App {
    public static String getForwardedVariables(String confFile) {
        List<String> resultList = Arrays.stream(confFile.split("\n"))
                .filter(x -> x.startsWith("environment"))
                .map(x -> x.replaceAll("environment=", ""))
                .flatMap(x -> Arrays.stream(x.split(",")))
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replaceAll("X_FORWARDED_", ""));
        String result = "";
        for (String item : resultList) {
            result += item + ", ";
        }
        return result;
    }
}*/
class App {
    /*    public static String getForwardedVariables(String confFile) {
            String[] fixparam = Arrays.stream(confFile.split("\n"))
                    .filter(x -> x.startsWith("environment"))
                    .map(x -> x.replaceAll("environment=", ""))
                    .flatMap(x -> Arrays.stream(x.split(",")))
                    .filter(x -> x.startsWith("X_FORWARDED_"))
                    .map(x -> x.replaceAll("X_FORWARDED_", ""))
                    .toArray(String[]::new);
            String result = "";
            for (String i : fixparam ) {
                result += i;
            }
            return result;
        }*/
    public static String getForwardedVariables(String confFile) {
        String[] fixparam = Arrays.stream(confFile.split("\n"))
                .filter(x -> x.startsWith("environment"))
                .map(x -> x.replaceAll("environment=", ""))
                .map(x -> x.replaceAll("\"", ""))
                .flatMap(x -> Arrays.stream(x.split(",")))
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replaceAll("X_FORWARDED_", ""))
                .toArray(String[]::new);
        return String.join(",", fixparam);
    }
}
//END
