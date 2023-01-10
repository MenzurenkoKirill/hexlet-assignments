package exercise;

// BEGIN
class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;
    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return area + balconyArea;
    }
    @Override
    public int compareTo(Home anotherHome) {
        if (this.getArea() > anotherHome.getArea()) {
            return 1;
        } else if (this.getArea() < anotherHome.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
