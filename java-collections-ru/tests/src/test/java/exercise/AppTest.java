package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        int sizeNewList = 3;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> newNumbers = App.take(numbers, sizeNewList);
        assertThat(newNumbers).isNotEmpty();

        // END
    }
}
