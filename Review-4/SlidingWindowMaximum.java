import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        // Deque stores indices, in decreasing order
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // remove indices that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // Remove smaller elements because current larger element exists
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {

                deque.pollLast();
            }

            deque.offerLast(i);

            // Window becomes valid once first k elements are processed
            if (i >= k - 1) {

                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};

        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
}