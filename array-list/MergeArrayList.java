import java.util.ArrayList;

public class MergeArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(10);
        list1.add(20);

        list2.add(30);
        list2.add(40);

        // Add all elements of list2 into list1
        list1.addAll(list2);

        System.out.println(list1);
    }
}