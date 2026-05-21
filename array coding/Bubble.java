
public class Bubble {
    public static void main(String[] args) {
        int arr[] = {2, 4, -3, 89, 1, -79};
        int n = arr.length;

        for(int j = 1; j < n; j++) {
            for(int i = n-1; i >= j; i--) {
                if(arr[i-1] > arr[i]) {
                int t = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = t;
            }
        }
    }

        for(int i = 0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}