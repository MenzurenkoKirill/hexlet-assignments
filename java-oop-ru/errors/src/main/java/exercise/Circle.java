package exercise;

// BEGIN
class Circle {

    private Point point;
    private int radius;
    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }
    int getRadius() {
        return this.radius;
    }
    double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Circle radius less than zero");
        }
        double square = (radius * radius) * Math.PI;
        return square;
    }
}
// END
