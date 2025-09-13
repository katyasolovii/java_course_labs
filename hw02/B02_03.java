package hw02;
import java.util.Scanner; 

public class B02_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = in.nextInt(); 
        System.out.println("Enter b:");
        int b = in.nextInt(); 

        System.out.println("Enter the length of the array:");
        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter array[" + i + "] element:");
            array[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++){
            if (array[i] >= a && array[i] <= b) {
                System.out.print(array[i] + " ");
            }
        }

        in.close();
    }
}
