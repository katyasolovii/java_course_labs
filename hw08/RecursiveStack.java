package hw08; 

public class RecursiveStack<S> {
    private S data;
    private RecursiveStack<S> next;

    public RecursiveStack() {
        this.data = null;
        this.next = null;
    }

    public void push(S value) {
        if (data == null) {
            data = value;
        }
        else {
            RecursiveStack<S> newNode = new RecursiveStack<>();
            newNode.data = data;
            newNode.next = next;
            data = value;
            next = newNode;
        }
    }

    public S pop()  {
        if (isEmpty()){
            return null;
        }
        S topValue = data;
        if (next != null) {
            data = next.data;
            next = next.next;
        }
        else {
            data = null;
            next = null;
        }
        return topValue;
    }

    public S peek() {
        return data;
    }

    public boolean isEmpty() {
        return data == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        if (next == null || next.isEmpty()) {
            return "[" + data + "]";
        }
        return "[" + data + ", " + next.toString().substring(1); 
    }
}