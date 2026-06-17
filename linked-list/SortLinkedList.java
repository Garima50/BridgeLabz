import java.util.LinkedList;
import java.util.Collections;

public class SortLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(40);
        list.add(10);
        list.add(30);
        list.add(20);

        // Sort LinkedList
        Collections.sort(list);

        System.out.println(list);
    }
}