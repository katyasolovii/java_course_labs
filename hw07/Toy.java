package hw07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Toy implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public String name;
    public double price;
    public int minAge;
    public int maxAge;

    public Toy(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return name + " (" + price + " грн, " + minAge + "-" + maxAge + " р.)";
    }

    public static void write(String out, List<Toy> lst) {
        try {
            var f = new ObjectOutputStream(
                new FileOutputStream(out)
            );
            for (Toy toy : lst) {
                f.writeObject(toy);
            }
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Toy> read(String inp) {
        List<Toy> lst = new ArrayList<>();
        try {
           var f = new ObjectInputStream(
                new FileInputStream(inp)
            );
            while (true) {
                try {
                    lst.add((Toy) f.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }

    public static List<Toy> forAge(List<Toy> lst, int age) {
        List<Toy> res = new ArrayList<>();
        for (Toy t : lst) {
            if (age >= t.minAge && age <= t.maxAge) {
                res.add(t);
            }
        }
        return res;
    }
}
