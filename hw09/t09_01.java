package hw09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.ArrayBlockingQueue;

public class t09_01 {

    public static void main(String[] args) throws InterruptedException {

        double T1 = 2.0;
        double T2 = 4.0;
        double T3 = 6.0;
        final int n = 20;

        long readTime = (long) (T1 * 1000);
        long timeW1   = (long) (T2 * 1000);
        long timeW2   = (long) (T3 * 1000);

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(n);

        Thread reader  = new Thread(() -> readFiles("hw09/input.txt", queue, readTime));
        Thread w1 = new Thread(() -> process(queue, timeW1, "w1.txt"));
        Thread w2 = new Thread(() -> process(queue, timeW2, "w2.txt"));

        System.out.println("Start!");

        reader.start();
        w1.start();
        w2.start();

        reader.join();

        queue.put("END");
        queue.put("END");

        w1.join();
        w2.join();

        System.out.println("End!");
    }

    public static void readFiles(String filename, ArrayBlockingQueue<String> queue, long delay) {
        Thread.currentThread().setName("Reader");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reader read: " + line);
                queue.put(line);
                Thread.sleep(delay);
            }
        } catch (Exception err) {
            System.out.println("Reader ERROR: " + err.getMessage());
        } 
    }

    public static void process(ArrayBlockingQueue<String> queue, long delay, String outputFile) {
        Thread.currentThread().setName("Worker-" + outputFile);

        FileWriter fw = null;

        try {
            fw = new FileWriter(outputFile);
            while (true) {
                String msg = queue.take();
                if ("END".equals(msg))
                    break;
                System.out.println(Thread.currentThread().getName() + " got: " + msg);
                Thread.sleep(delay);
                fw.write(msg + "\n");
                System.out.println(Thread.currentThread().getName() + " processed: " + msg);
            }
        } catch (Exception err) {
            System.out.println("Worker ERROR: " + err.getMessage());
        }
    }
}
