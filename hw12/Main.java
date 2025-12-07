package hw12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String fileName = "hw12/information/input05.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));

            String directionLine = reader.readLine();
            String direction = directionLine.trim();
            String needCreditsLine = reader.readLine();
            int needCredits = Integer.parseInt(needCreditsLine.trim());
            String moneyLine = reader.readLine();
            int money = Integer.parseInt(moneyLine.trim());

            BaseStudent student;
            if (direction.equals("humanitarian")) {
                student = new HumanitarianStudent(needCredits, money);
            } else if (direction.equals("natural")) {
                student = new NaturalStudent(needCredits, money);
            } else {
                student = new MixedStudent(needCredits, money);
            }

            String currentLine = reader.readLine();
            while (currentLine != null) {
                currentLine = currentLine.trim();

                if (currentLine.isEmpty()) {
                    currentLine = reader.readLine();
                    continue;
                }

                String[] parts = currentLine.split("\\s+");
                String command = parts[0];

                int value = 0;
                String teachType = "";

                if (command.equals("teach")) {
                    teachType = parts[1]; 
                    value = Integer.parseInt(parts[2]);
                } else if (command.equals("pay")) {
                    if (parts[1].equals("hostel")) {
                        command = "pay_hostel";
                    } else if (parts[1].equals("canteen")) {
                        command = "pay_canteen";
                    }
                    value = Integer.parseInt(parts[2]);
                } else if (command.equals("obtain")) {
                    if (parts[1].equals("scholarship")) {
                        command = "obtain_scholarship";
                    } else if (parts[1].equals("help")) {
                        command = "obtain_help";
                    }
                    value = Integer.parseInt(parts[2]);
                }
                StudentVisitor visitor = new StudentVisitor(command, value);
                if (command.equals("teach")) {
                    visitor.setTeachType(teachType);
                }
                student.visit(visitor);
                if (student.isExpelled()) {
                    break;
                }
                currentLine = reader.readLine();
            }

            if (student.hasDiploma()) {
                System.out.println("Student obtained a diploma!");
            } else if (student.isExpelled()) {
                System.out.println("Student was expelled!");
            } else {
                System.out.println("Student didn't get enough credits for diploma!");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
