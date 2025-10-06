package hw05;

public class t05_01 {
    public static void main(String[] args) {
        String s = "текст з вкладеними дужками (всередині) і() зовні)";
        String s1 = "текст з вкладеними дужками (всередині і зовні)";
        System.out.println(a(s));
        System.out.println(a(s1));
    }

    public static String a(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (count > 0) {
                    return "Incorrect placement of brackets";
                }
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    return "Incorrect placement of brackets";
                }
                count--;
            }
        }

        if (count != 0) {
            return "Incorrect placement of brackets";
        }

        return s.replaceAll("\\([^()]*\\)", "");
    }

}
