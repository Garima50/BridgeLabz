
public class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {

        this.capacity = capacity;

        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // insert element at rear
    public boolean enqueue(int value) {

        if (isFull()) {
            return false;
        }

        // Move rear in circular manner
        rear = (rear + 1) % capacity;

        queue[rear] = value; // assign value to rear

        size++; //increment size

        return true;
    }

    // remove element from front
    public boolean dequeue() {

        if (isEmpty()) {
            return false;
        }

        // Move front in circular manner
        front = (front + 1) % capacity;

        size--;

        return true;
    }

    // return front value
    public int front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    // return rear value
    public int rear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    // checks empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    // checks if full or not
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.dequeue();

        q.enqueue(40);

        while (!q.isEmpty()) {

            System.out.print(q.front() + " ");

            q.dequeue();
        }
    }
}