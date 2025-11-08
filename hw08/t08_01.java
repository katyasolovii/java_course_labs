package hw08;

/*
 * Описати клас стек як рекурсивну структуру даних, 
 * який приймає об’єкти довільного типу.
*/

public class t08_01 {
    public static void main(String[] args) {
        RecursiveStack<String> stack = new RecursiveStack<>();

        stack.push("vf");
        stack.push("231.4");

        System.out.println("Stack:" + stack);
        stack.push("sd9ds..");
        System.out.println("Stack:" + stack);
        System.out.println("Верхній елемент стека: " + stack.peek()); 
        System.out.println("Видалення та повернення верхнього елемента стека: " + stack.pop());  
        System.out.println("Stack:" + stack);
        System.out.println("Видалення та повернення верхнього елемента стека: " + stack.pop());  
        System.out.println("Is empty? " + stack.isEmpty()); 
        System.out.println("Видалення та повернення верхнього елемента стека: " + stack.pop());  
        System.out.println("Is empty? " + stack.isEmpty()); 
    }
}