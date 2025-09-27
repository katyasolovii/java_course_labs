package hw04;

public class Main {
    public static void main(String[] args) {
        Coffee[] coffees = {
            new Arabica(650, 5),
            new Robusta(350.50, 7),
            new Arabica(1000.50, 4),
            new Robusta(2500, 6),
            new Arabica(3050.50, 8),
            new Liberica(200, 5),
            new Liberica(800, 3)
        };

        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
        CoffeeVan van = new CoffeeVan(coffees);
        System.out.println("\nЗагальна вартість кави: " + van.getTotalPrice() + " грн.");
        van.sort();
        System.out.println("\nКава після сортування: " + van);
        System.out.println("\nКава з міцністю від 3 до 6: " + van.getCoffeeByStrength(3, 6));

    }
    
}
