import java.util.LinkedList;
import java.util.Queue;

public class QueueMethods {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // Insert elements
        queue.offer("Java");
        queue.offer("Python");
        queue.offer("C++");

        // Display queue
        System.out.println(queue);

        // Peek front element
        System.out.println("Peek: " + queue.peek());

        // Remove element
        System.out.println("Poll: " + queue.poll());

        // Check size
        System.out.println("Size: " + queue.size());

        // Check if empty
        System.out.println("Is Empty: " + queue.isEmpty());
    }
}