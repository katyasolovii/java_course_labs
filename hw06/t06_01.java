package hw06;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t06_01 {
    public static void main(String[] args) throws Exception {
        String s = Files.readString(Path.of("hw06/input.txt"));
        String rgs = "\\b(\\d{2}\\.\\d{2}\\.\\d{4}|_+\\._+\\._+)\\b";

        Pattern p = Pattern.compile(rgs);
        Matcher m = p.matcher(s);
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        String res = m.replaceAll(data);
        System.out.println("\n" + res);
        Files.writeString(Path.of("hw06/output.txt"), res);
    }
}
