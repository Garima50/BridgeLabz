import java.util.LinkedList;

public class MergeLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.add(10);
        list1.add(20);

        list2.add(30);
        list2.add(40);

        // Merge second list into first list
        list1.addAll(list2);

        System.out.println(list1);
    }
}