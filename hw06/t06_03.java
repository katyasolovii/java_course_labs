package hw06;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class t06_03 {
    public static void main(String[] args) throws Exception {
        String s = "2 – 5 7 *  3 3 + 2 5/ - 4     9 -";
        String s1 = " + 3     *8 - 6   /2";
        String s2=  " - 4*2 + 1   /    3";
        String s3 = " 5 +  3*  7 4 - 2";
        String s4 = " 1 0     /       2 - 3 + 6 *     4";
        String s5 = " 4 + fds * 3 - 2 ";

        String rgs = "\\s*[+-]?\\d(\\s*\\d)*(\\s*[+\\-*/]\\s*\\d(\\s*\\d)*)*\\s*";
        Pattern p = Pattern.compile(rgs);

        Matcher m = p.matcher(s);
        Matcher m1 = p.matcher(s1);
        Matcher m2 = p.matcher(s2);
        Matcher m3 = p.matcher(s3);
        Matcher m4 = p.matcher(s4); 
        Matcher m5 = p.matcher(s5); 

        System.out.println("s: " + m.matches());
        System.out.println("s1: " + m1.matches());
        System.out.println("s2: " + m2.matches());
        System.out.println("s3: " + m3.matches());
        System.out.println("s4: " + m4.matches());
        System.out.println("s5: " + m5.matches());
    }
}