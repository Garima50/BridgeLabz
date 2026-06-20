import java.util.ArrayDeque;

public class ArrayDequeStack {
    public static void main(String[] args) {

        // Stack implementation using ArrayDeque
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        // Peek top
        System.out.println("Top: " + stack.peek());

        // Pop top
        System.out.println("Pop: " + stack.pop());

        System.out.println(stack);
    }
}