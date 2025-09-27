package hw04;

public class Liberica extends Coffee {

    public Liberica(double weight, double strength) {
        super("Liberica", weight, strength);
    }

    @Override
    public double getPrice() {
        return 8.50 * getWeight() + getStrength() * 0.5;
    }

    @Override
    public String toString() {
        return "Тип кави: " + getType() + ", вага: " + getWeight() + " гр." + ", міцність: " + getStrength() + ", ціна: " + getPrice() + " грн."; 
    }
    
}
