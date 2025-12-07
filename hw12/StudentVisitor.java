package hw12;

public class StudentVisitor implements Visitor {

    public String command;
    public int value;
    public String teachType; 

    public StudentVisitor(String command, int value) {
        this.command = command;
        this.value = value;
        this.teachType = ""; 
    }

    public void setTeachType(String teachType) {
        this.teachType = teachType;
    }

    @Override
    public void visit(HumanitarianStudent student) {
        doAction(student, "humanitarian");
    }

    @Override
    public void visit(NaturalStudent student) {
        doAction(student, "natural");
    }

    @Override
    public void visit(MixedStudent student) {
        doAction(student, "mixed");
    }

    public void doAction(BaseStudent student, String studentType) {
        if (command.equals("teach")) {
            if (studentType.equals("humanitarian")) {
                if (teachType.equals("humanitarian")) {
                    student.addCredits(value);
                }
            } else if (studentType.equals("natural")) {
                if (teachType.equals("natural")) {
                    student.addCredits(value);
                }
            } else if (studentType.equals("mixed")) {
                student.addCredits(value);
            }
        } else if (command.equals("pay_hostel")) {
            student.pay(value);
        } else if (command.equals("pay_canteen")) {
            student.pay(value);
        } else if (command.equals("obtain_scholarship")) {
            student.addMoney(value);
        } else if (command.equals("obtain_help")) {
            student.addMoney(value);
        }
    }
}
