public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = {10, 45, 20, 60, 35};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Visit every element once
        for (int num : arr) {

            // Found a new largest element
            if (num > largest) {

                secondLargest = largest;
                largest = num;
            }

            // Update second largest only if needed
            else if (num > secondLargest && num != largest) {

                secondLargest = num;
            }
        }

        System.out.println("Second Largest Element: " + secondLargest);
    }
}