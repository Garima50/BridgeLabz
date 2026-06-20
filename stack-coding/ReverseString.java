import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {

        String str = "JAVA";

        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters in reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}