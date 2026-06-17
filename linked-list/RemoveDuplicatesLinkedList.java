import java.util.LinkedList;

public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(10);
        list.add(30);

        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).equals(list.get(j))) {

                    list.remove(j);
                    j--;
                }
            }
        }

        System.out.println(list);
    }
}