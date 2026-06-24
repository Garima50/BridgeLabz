import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {

        // ArrayDeque coz its faster and not a legacy class
        Deque<Integer> stk = new ArrayDeque<>();

        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            // For the last iteration, use height 0, so that all remaining bars are processed.
            int currentHeight = (i == n) ? 0 : heights[i];

            // to process bars that are taller than current bar
            while (!stk.isEmpty() && currentHeight < heights[stk.peek()]) {

                int height = heights[stk.pop()];

                // If stk becomes empty, rectangle extends from index 0 to i-1
                int width = stk.isEmpty() ? i : i - stk.peek() - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            // Store current index
            stk.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));

    }
}
