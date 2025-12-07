package hw12;

public interface Student {
    public void visit(Visitor visitor);
    boolean isExpelled();
    boolean hasDiploma();
}
