package hw04;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeVan  {

    public Coffee[] coffees;

    public CoffeeVan(Coffee[] coffees) {
        this.coffees = coffees;
    }

    @Override
    public String toString() {
        return Arrays.toString(coffees);
    }
    

    public double getTotalPrice() {
        double result = 0.0;
        for (Coffee coffee : coffees) {
            result += coffee.getPrice();
        }
        return result;
    }

    public void sort() {
        Arrays.sort(coffees);
    }

    public CoffeeVan getCoffeeByStrength(double botton, double top) {
        ArrayList<Coffee> list = new ArrayList<>();
        for (int i = 0; i < coffees.length; i++) {
            if (coffees[i].getStrength() >= botton && coffees[i]. getStrength() <= top) {
                list.add(coffees[i]);
            }
        }
        Coffee[] array = list.toArray(new Coffee[0]);
        return new CoffeeVan(array);
    }
}
