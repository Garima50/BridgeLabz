public class SecondLargest {
    public static void main(String[] args) {
        int arr[] = {2, 5, 10, 2, 4};
        int n = arr.length;

        int largest = arr[0];
        int second = arr[0];

        for(int num: arr) {
            if(num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }
        System.out.println(second);

    }
}