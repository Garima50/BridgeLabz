import java.util.ArrayDeque;

public class ArrayDequeQueue {
    public static void main(String[] args) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Add elements at rear
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);

        // Remove from front
        System.out.println("Removed: " + queue.poll());

        System.out.println(queue);
    }
}