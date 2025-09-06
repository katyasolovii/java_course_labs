package hw_01;

public class B01_03 {
    public static void main(String[] args) {
        int res = 1;
        for (int i = 0; i < args.length; i++){
            try {
                res *= Integer.parseInt(args[i]);
            } 
            catch(NumberFormatException e) {
                System.out.println("Аргументи не є цілими числами");
                System.exit(0);
            }
        }
        System.out.println(res);
    }
}
