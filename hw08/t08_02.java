package hw08;
/*
 * Рядок складається з таких символів: '(', ')', '[', ']', '{', '}'. 
 * Перевірити правильність розстановки дужок. Використати стек.
 */

public class t08_02 {
    public static void main(String[] args) {
        String[] s = {
            "()[]{}",    
            "([{}])",    
            "(]",       
            "((()))",  
            "{[()()",
            "({[)]}",   
            "" 
        };

        for (int i=0; i < s.length; i++){
            String l = s[i];
            System.out.println("Рядок: " + l);
            if (isBalanced(l)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
    
    public static boolean isBalanced(String str) {
        RecursiveStack<Character> stack = new RecursiveStack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
