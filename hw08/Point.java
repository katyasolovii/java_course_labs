package hw08;

public class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Point other) {
        double d1 = this.distance();
        double d2 = other.distance();
        if (d1 < d2) {
            return -1;
        } else if (d1 > d2) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
