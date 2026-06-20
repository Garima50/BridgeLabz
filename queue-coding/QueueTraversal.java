import java.util.LinkedList;
import java.util.Queue;

public class QueueTraversal {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Traversing queue using for-each loop
        for (Integer element : queue) {
            System.out.println(element);
        }
    }
}