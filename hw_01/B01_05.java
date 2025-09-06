package hw_01;

import java.util.Scanner;

public class B01_05 {
    public static void main(String[] args) {
        int n, m;

        if (args.length >= 2) {
            n = Integer.parseInt((args[0]));
            m = Integer.parseInt(args[1]);
        }
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter N: ");
            n = in.nextInt();
            System.out.println("Eneter M: ");
            m = in.nextInt();
            in.close();
        }

        for (int i = 0; i < n; i++) {
            int res = (int) (Math.random() * m);
            System.out.println(res);
        }
    }
}
