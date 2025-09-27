package hw04;

public class Robusta extends Coffee {

    public Robusta(double weight, double strength) {
        super("Robusta", weight, strength);
    }

    @Override
    public double getPrice() {
        return 2.50 * getWeight() + getStrength() * 0.5;
    }

    @Override
    public String toString() {
        return "Тип кави: " + getType() + ", вага: " + getWeight() + " гр." + ", міцність: " + getStrength() + ", ціна: " + getPrice() + " грн."; 
    }
    
}
