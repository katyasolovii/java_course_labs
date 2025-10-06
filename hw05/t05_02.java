package hw05;

public class t05_02 {
    public static void main(String[] args) {
        String s1 = "3abc";
        String s2 = "4abc";
        String s3 = "";
        String s4 = "5abcde";
        String s5 = "3cs1";
        System.out.println(a(s1)); 
        System.out.println(a(s2)); 
        System.out.println(a(s3)); 
        System.out.println(a(s4)); 
        System.out.println(a(s5)); 
        System.out.println("----");
        System.out.println(b(s1)); 
        System.out.println(b(s2)); 
        System.out.println(b(s3)); 
        System.out.println(b(s4)); 
        System.out.println(b(s5)); 
        System.out.println("----");
        System.out.println(c(s1));
        System.out.println(c(s2)); 
        System.out.println(c(s3)); 
        System.out.println(c(s4)); 
        System.out.println(c(s5)); 
    }

    /* рядок починається з деякої ненульової цифри, за якою знаходяться тільки
    літери і їх кількість дорівнює числовому значенню цієї цифри; */

    public static boolean a(String s) {
        if (s.isEmpty()) {
            return false;
        }

        char firstChar = s.charAt(0);
        
        if (!Character.isDigit(firstChar)) {
            return false;
        }

        int n = Character.getNumericValue(firstChar); 

        if (n == 0) {
            return false;
        }   
        if (s.length() != n + 1) {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* рядок містить (крім літер) тільки одну цифру, причому її числове
    значення дорівнює довжині рядка; */

    public static boolean b(String s) {
        if (s.isEmpty()) {
            return false;
        }

        int digitCount = 0;
        int digitValue = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digitCount++;
                digitValue = Character.getNumericValue(c);
            } 
            else if (!Character.isLetter(c)) {
                return false;
            }
        }

        if (digitCount != 1) {
            return false;
        }

        return s.length() == digitValue;
    }

    /* сума числових значень цифр, які входять в рядок, дорівнює довжині
    рядка. */

    public static boolean c(String s) {
        if (s.isEmpty()) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            } else if (!Character.isLetter(c)) {
                return false;
            }
        }

        return sum == s.length();
    }
}
