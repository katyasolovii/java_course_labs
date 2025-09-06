package hw_01;

import java.util.Scanner;

public class B01_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int a = in.nextInt();
        System.out.println("Enter the second number: ");
        int b = in.nextInt();
        System.out.println("Enter the third number: ");
        int c = in.nextInt();

        double geomtric_mean = Math.cbrt(a* b * c);
        System.out.printf("Result: %.4f\n", geomtric_mean);

        in.close();
    }
}
