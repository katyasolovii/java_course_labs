package hw08;
import java.util.PriorityQueue;

/*
 * На площині знаходяться n точок. Вивести всі точки у 
 * порядку зростання їх відстаней до центру координат. 
 * Використати клас PriorityQueue.
 */

public class t08_04 {
    public static void main(String[] args) {
        Point[] points = {
            new Point(1, 2),
            new Point(8, 12),
            new Point(3, 0),
            new Point(-7, 1)
        };

        PriorityQueue<Point> pq = new PriorityQueue<Point>();

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }

        System.out.println("Точки у порядку зростання відстані до центру:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}