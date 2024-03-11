package exercise;

class SafetyList {
    // BEGIN
    private int[] array = new int[10];
    private int size = 0;

    public synchronized void add(int number) {
        if (array.length > size) {
            array[size] = number;
            size = size + 1;
        } else {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[size] = number;
            size = size + 1;
        }
    }

    public int get(int index) {
        return array[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
