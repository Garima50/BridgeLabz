import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        // Stores number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Number needed to reach target
            int complement = target - nums[i];

            // Check if required number already exists
            if (map.containsKey(complement)) {

                System.out.println(
                        "Indices: " +
                        map.get(complement) +
                        " , " + i);

                return;
            }

            // Store current number and index
            map.put(nums[i], i);
        }
    }
}