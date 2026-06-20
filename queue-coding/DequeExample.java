import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        // Add from both ends
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);

        System.out.println(deque);

        // Remove from both ends
        System.out.println("First Removed: " + deque.removeFirst());
        System.out.println("Last Removed: " + deque.removeLast());
    }
}