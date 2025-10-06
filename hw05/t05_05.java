package hw05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class t05_05 {
    public static void main(String[] args) {
        // System.out.println(System.getProperty("user.dir"));
        a("/Users/katyasolovii/Documents/univer/3course/java/hw05/cars_data.txt", "Toyota", "/Users/katyasolovii/Documents/univer/3course/java/hw05/result_a.txt");
        b("/Users/katyasolovii/Documents/univer/3course/java/hw05/cars_data.txt", "/Users/katyasolovii/Documents/univer/3course/java/hw05/result_b.txt");
    }

    public static void a(String input, String brand, String output) {
        try {
            FileReader fr = new FileReader(input);
            Scanner sc = new Scanner(fr);

            FileWriter fw = new FileWriter(output);
            PrintWriter pw = new PrintWriter(fw);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String[] parts = line.split("\\s+");

                String carBrand = parts[0];
                String owner = parts[2];

                if (carBrand.equalsIgnoreCase(brand)) {
                    pw.println(owner);
                }
            }

            sc.close();
            pw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }


    public static void b(String input, String output) {
        Path pathInp = Path.of(input);
        Path pathOut = Path.of(output);

        try {

            List<String> lines = Files.readAllLines(pathInp);

            List<String> brands = new java.util.ArrayList<>();
            List<Integer> counts = new java.util.ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                String[] parts = line.split("\\s+");

                String brand = parts[0];
                boolean found = false;

                for (int j = 0; j < brands.size(); j++) {
                    if (brands.get(j).equalsIgnoreCase(brand)) {
                        counts.set(j, counts.get(j) + 1);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    brands.add(brand);
                    counts.add(1);
                }
            }

            List<String> outputLines = new java.util.ArrayList<>();
            for (int i = 0; i < brands.size(); i++) {
                outputLines.add(brands.get(i) + " " + counts.get(i));
            }

            Files.write(pathOut, outputLines);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
