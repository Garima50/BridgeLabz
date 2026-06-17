public class Bubble {

    public static void main(String[] args) {

        int[] arr = {5, 2, 8, 1, 9};

        // Outer loop controls the number of passes
        for (int i = 0; i < arr.length - 1; i++) {

            // Used to check if any swapping happened
            boolean swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < arr.length - 1 - i; j++) {

                // Swap if left element is greater
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop early if array is already sorted
            if (!swapped) {
                break;
            }
        }

        System.out.print("Sorted Array: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}