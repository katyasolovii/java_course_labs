package hw02;
import java.util.Scanner; 

public class B02_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n");
        byte n = in.nextByte();
        System.out.println("Enter k");
        byte k = in.nextByte();

        // System.out.println(n + " -> " + Integer.toBinaryString(n));
        // System.out.println(k + " -> " + Integer.toBinaryString(k));

        int t =  ~(1 << k);
        // System.out.println(t);
        int res = n & t;
        System.out.println(res);

        in.close();
    }
    
}
