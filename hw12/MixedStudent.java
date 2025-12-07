package hw12;

public class MixedStudent extends BaseStudent {
    public MixedStudent(int needCredits, int money) {
        super(needCredits, money);
    }
    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
