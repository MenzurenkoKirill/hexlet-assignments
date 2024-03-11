package exercise;

// BEGIN
public class ListThread extends Thread {

    // Разделяемый ресурс
    SafetyList list;

    ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (var i = 0; i < 1000; i++) {
            int number = (int) (1 + Math.random() * (100));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(number);
        }
    }
}
// END
