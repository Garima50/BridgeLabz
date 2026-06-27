
import java.util.HashMap;

public class LongestHarmoniusSubsequence {

    public static int findLHS(int[] nums) {
        // to store each no and freq
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        //traverse the array and count freq
        for(int num: nums) {
            // freq increase if no exists else insert with freq 1
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // max length
        int longestLength = 0;
        
        //traverse all unique no
        for(int num: freqMap.keySet()){
            // if consecutive no is there
            if(freqMap.containsKey(num+1)) {
                //cal total freq of both 
                int currLength = freqMap.get(num) + freqMap.get(num + 1);

                //update max length if found
                longestLength = Math.max(longestLength, currLength);
            }
        }

        return longestLength;

    }
    public static void main(String[] args) {
        int []nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
}