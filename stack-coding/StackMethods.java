import java.util.Stack;

public class StackMethods {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        // Add elements
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");

        // Display stack
        System.out.println(stack);

        // Peek top element
        System.out.println("Peek: " + stack.peek());

        // Search element position from top
        System.out.println("Search Python: " + stack.search("Python"));

        // Check empty
        System.out.println("Is Empty: " + stack.isEmpty());

        // Stack size
        System.out.println("Size: " + stack.size());
    }
}