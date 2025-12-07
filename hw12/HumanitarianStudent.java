package hw12;

public class HumanitarianStudent extends BaseStudent {
    public HumanitarianStudent(int needCredits, int money) {
        super(needCredits, money);
    }
    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
