import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Push elements onto stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);

        // View top element
        System.out.println("Top Element: " + stack.peek());

        // Remove top element
        System.out.println("Popped Element: " + stack.pop());

        System.out.println("Stack After Pop: " + stack);
    }
}