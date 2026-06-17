import java.util.ArrayList;
import java.util.Collections;

public class MaxElement {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(40);
        list.add(10);
        list.add(70);
        list.add(20);

        // Returns largest element
        System.out.println(Collections.max(list));
    }
}