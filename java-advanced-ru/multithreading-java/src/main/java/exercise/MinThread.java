package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private final int[] numbers;
    private int result;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int min = Arrays.stream(numbers).min().getAsInt();
        this.result = min;
    }

    public int getResult() {
        return result;
    }
}
// END
