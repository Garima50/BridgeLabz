import java.util.LinkedList;

public class SearchLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        int key = 20;

        // Check if element exists
        if (list.contains(key)) {
            System.out.println("Element Found");
        } else {
            System.out.println("Element Not Found");
        }
    }
}