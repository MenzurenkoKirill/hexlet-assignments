package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        long email1 = emails.stream()
                .filter(name -> name.contains("@gmail.com"))
                .count();
        long email2 = emails.stream()
                .filter(name -> name.contains("@yandex.ru"))
                .count();
        long email3 = emails.stream()
                .filter(name -> name.contains("@hotmail.com"))
                .count();
        return email1 + email2 + email3;
    }
}
// END
