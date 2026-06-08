public class MaxDiff {
    public static void main(String[] args) {
        int []arr = {2, 3, 5, 10, 7, 9};

        int min = arr[0];
        int maxd = 0;

        for(int i = 1; i < arr.length; i++){
            maxd = Math.max(maxd, arr[i]-min); // to find larger value
        }
        System.out.println("Max diff: " + maxd);
    }
}