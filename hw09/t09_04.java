package hw09;

import java.util.concurrent.locks.ReentrantLock;

public class t09_04 {

    public static void main(String[] args) throws InterruptedException {
        double T1 = 2.0;
        double T2 = 4.0;
        double T3 = 8.0;
        double T4 = 15.0;
        final int n = 10;
        final int[] money = {0};

        ReentrantLock lock = new ReentrantLock(true);
        Thread[] CarPark = new Thread[n];
        boolean[] parkingSpaces = new boolean[n];

        for (int i = 0; i < n; i++) {
            int carId = i + 1;
            CarPark[i] = new Thread(() -> {
                try {
                    double arriveSec = T1 + Math.random() * (T2 - T1);
                    Thread.sleep((long)(arriveSec * 1000));

                    boolean parked = false;

                    lock.lock();
                    for (int j = 0; j < n; j++) {
                        if (!parkingSpaces[j]) {
                            parkingSpaces[j] = true;
                            parked = true;
                            System.out.println("Car " + carId + " зайняв місце " + j);
                            break;
                        }
                    }
                    lock.unlock(); 

                    if (parked) {
                        double parkTime = T3 + Math.random() * (T4 - T3);
                        int earned = (int) parkTime;
                        money[0] += earned;
                        Thread.sleep((long)(parkTime * 1000));

                        lock.lock();
                        for (int j = 0; j < n; j++) {
                            if (parkingSpaces[j]) {
                                parkingSpaces[j] = false;
                                System.out.println("Car " + carId + " звільнив місце " + j);
                                break;
                            }
                        }
                        lock.unlock();
                    } else {
                        System.out.println("Car " + carId + " не знайшов місця і поїхав");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            CarPark[i].start();
        }

        for (int i = 0; i < CarPark.length; i++) {
            CarPark[i].join();
        }

        System.out.println("Зароблено грошей: " + money[0]);
    }
}
