import java.util.Stack;

public class StackTraversal {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(200);
        stack.push(300);

        // Traverse stack using for-each loop
        for (Integer element : stack) {
            System.out.println(element);
        }
    }
}