import java.util.Stack;

public class QueueUsingStacks {

    // First stack is used for enqueue operations
    Stack<Integer> stack1 = new Stack<>();

    // Second stack is used for dequeue operations
    Stack<Integer> stack2 = new Stack<>();

    // Method to insert an element into the queue
    void enqueue(int data) {

        // Push the new element into stack1
        // Elements are stored in insertion order here
        stack1.push(data);

        System.out.println(data + " added to queue");
    }

    // Method to remove an element from the queue
    int dequeue() {

        // If both stacks are empty, queue has no elements
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // If stack2 is empty, transfer all elements
        // from stack1 to stack2
        if (stack2.isEmpty()) {

            // Move elements one by one
            while (!stack1.isEmpty()) {

                // Remove top element from stack1
                int value = stack1.pop();

                // Push into stack2
                // This reverses the order and gives FIFO behavior
                stack2.push(value);
            }
        }

        // Remove and return the front element of the queue
        return stack2.pop();
    }

    public static void main(String[] args) {

        // Create QueueUsingStacks object
        QueueUsingStacks q = new QueueUsingStacks();

        // Insert elements into queue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Remove elements following FIFO order
        System.out.println("Dequeued Element: " + q.dequeue());

        System.out.println("Dequeued Element: " + q.dequeue());
    }
}