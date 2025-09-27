package hw04;

public abstract class Coffee implements Comparable<Coffee> {

    private String type;
    private double weight;
    private double strength;

    public Coffee(String name, double weight, double strength) {
        this.type = name;
        this.weight = weight;
        this.strength = strength;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void setType(String name) {
        this.type = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getStrength() {
        return strength;
    }

    public abstract double getPrice();

    @Override
    public int compareTo(Coffee other) {
        return Double.compare(getPrice(), other.getPrice());
    }
    
}
