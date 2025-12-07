package hw12;

public abstract class BaseStudent implements Student {
    public int credits;         
    public int needCredits;  
    public int money;         
    public boolean isExpelled;
    
    public BaseStudent(int needCredits, int money) {
        this.credits = 0;
        this.needCredits = needCredits;
        this.money = money;
        this.isExpelled = false;
    }

    @Override
    public boolean isExpelled() {
        return isExpelled;
    }

    @Override
    public boolean hasDiploma() {
        if (isExpelled) {
            return false;
        } else {
            if (credits >= needCredits) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void addCredits(int value) {
        credits += value;
    }

    public boolean pay(int amount) {
        if (money < amount) {
            isExpelled = true; 
            return false;
        }
        money -= amount;
        return true;
    }

    public void addMoney(int amount) {
        money += amount;
    }
}
