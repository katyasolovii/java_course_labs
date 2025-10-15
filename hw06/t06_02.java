package hw06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t06_02 {
    public static void main(String[] args) throws Exception {
        String s = "098-654-54-32 fdsfs 97-708-90-76 dfsfd945df 067-(654)-(98)-(76) " +
                   "+380-98-765-43-21 dfsfs-09dfs12fd 380(98)3456789 sfd/gfsgf\\gd 067 1234567";

        String rgs = "(\\+?380|0)?\\s*(\\(\\d{2}\\)|\\d{2})?(-|\\s)?\\d{3}(-|\\s)?\\d{2}(-|\\s)?\\d{2}\\b|\\b\\d{10}\\b";
        Pattern p = Pattern.compile(rgs);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
