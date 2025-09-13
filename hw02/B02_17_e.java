package hw02;
import java.util.Locale;
import java.util.Scanner; 

public class B02_17_e {
    public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
        System.out.println("Enter x:");
		double x = in.nextDouble();
        System.out.println("Enter eps:");
		double eps = in.nextDouble();
		
        System.out.println("Math.sin(x):");
		System.out.println(Math.sin(x));
        System.out.println("Result:");
        System.out.println(f(x, eps));
        in.close();
    }

	public static double f(double x, double eps) {
		if (Math.abs(x) >= 1)
			throw new RuntimeException("Wrong x!");
		if (eps <= 0)
			throw new RuntimeException("Wrong eps!");
		
        double s = 0;     
        double a = x;     
        int k = 0;

        while (Math.abs(a) > eps) {
            s += a;
            k++;
            a *= - x * x / ((2 * k) * (2 * k + 1)); 
        }

        return s;
    }
}
