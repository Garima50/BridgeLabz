import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        // Creates Min Heap by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        System.out.println("Priority Queue: " + pq);

        // Elements come out in sorted order
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}