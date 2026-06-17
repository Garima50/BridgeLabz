
import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        
            //stores sum and its freq    
            HashMap<Integer, Integer> map = new HashMap<>();
            
            // initial prefix sum count is 1
            map.put(0,1);
            
            // stores current sum
            int prefixsum = 0;

            int count = 0; // final ans

            for(int num : nums) {
                // add current element to sum
                prefixsum += num;
                // check if valid subarray exists
                if(map.containsKey(prefixsum - k)) {
                    // add number of sach subarrays
                    count += map.get(prefixsum - k);
                }
                // update value of current prefix sum
                map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);

            }

            // return total count of subarrays found
            return count;
        }

    public static void main(String[] args) {
       
        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println("No. of subarrays: " + subarraySum(nums, k));
        

    }
}
