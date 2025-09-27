package hw04;

public class Arabica extends Coffee {

    public Arabica(double weight, double strength) {
        super("Arabica", weight, strength);
    }

    @Override
    public double getPrice() {
        return 5.50 * getWeight() + getStrength() * 0.5;
    }

    @Override
    public String toString() {
        return "Тип кави: " + getType() + ", вага: " + getWeight() + " гр." + ", міцність: " + getStrength() + ", ціна: " + getPrice() + " грн."; 
    }

}
