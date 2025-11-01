package hw07;

import java.util.List;

public class t07_02 {
    public static void main(String[] args) {
        String inp = "/Users/katyasolovii/Documents/univer/3course/java/hw07/toys.bin";
        String out = "/Users/katyasolovii/Documents/univer/3course/java/hw07/toys_for_age.bin";


        List<Toy> toys = List.of(
            new Toy("Конструктор Lego", 850.0, 6, 14),
            new Toy("Плюшевий ведмедик", 300.0, 1, 8),
            new Toy("Настільна гра", 500.0, 8, 16),
            new Toy("М'яч", 150.0, 3, 10),
            new Toy("Лялька Барбі", 450.0, 4, 12)
        );

        Toy.write(inp, toys);

        var allToys = Toy.read(inp);
        System.out.println("Зміст записаного файлу:");
        for (Toy t : allToys) {
            System.out.println("  " + t);
        }

        int age = 7;
        var toysForChild = Toy.forAge(allToys, age);

        System.out.println("\nІграшки для дитини віком " + age + " років:");
        for (Toy t : toysForChild) {
            System.out.println("  " + t);
        }
    }
}
