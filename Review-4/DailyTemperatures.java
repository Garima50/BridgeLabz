import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] ans = new int[n];

        // stores indexes instead of temperatures
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // If current day is warmer than previous stored day then calculate no of days to wait
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();
                
                ans[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString( dailyTemperatures(temperatures)));
    }
}