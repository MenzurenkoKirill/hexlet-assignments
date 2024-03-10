package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int result;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = Arrays.stream(numbers).max().getAsInt();
        this.result = max;
    }

    public int getResult() {
        return result;
    }
}
// END
