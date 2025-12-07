package hw12;

public class NaturalStudent extends BaseStudent {
    public NaturalStudent(int needCredits, int money) {
        super(needCredits, money);
    }
    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
