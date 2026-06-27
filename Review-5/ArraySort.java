

public class ArraySort {

    public static void mergesort(int[] nums, int left, int right) {
        
        if(left < right) {

            //find middle index
            int mid = left + (right - left) / 2;

            //sort left side
            mergesort(nums, left, mid);

            //sort right side
            mergesort(nums, mid+1, right);

            //merge both sides
            merge(nums, left, mid, right);

        }

    }

    public static void merge(int[] nums, int left, int mid, int right) {
        //size of left half
        int size1 = mid - left + 1;
        //size of right half
        int size2 = right - mid;

        //create array for left and right halves
        int[] leftarray = new int[size1];
        int[] rightarray = new int[size2];

        //copy left half to temp. arrays
        for(int i = 0; i < size1; i++){
            leftarray[i] = nums[left + i];
        }

        //copy right half to temp. arrays
        for(int j = 0; j < size2; j++) {
            rightarray[j] = nums[mid + 1 + j];
        }

        //pointer for left temp array
        int i = 0; 
        //pointer for right temp array
        int j = 0;
        //pointer for original array
        int k = left;

        //compare from both temp arrays and keep smaller first
        while(i < size1 && j < size2) {

            //if left element is smaller or equal, copy
            if (leftarray[i] <= rightarray[j]) {
                nums[k] = leftarray[i];
                i++;
            }

            //else copy right eleemnt
            else {
                nums[k] = rightarray[j];
                j++;
            }

            //move to next posiiton in array
            k++;
        }

        //copy remaining from left
        while(i < size1) {
            nums[k] = leftarray[i];
            i++;
            k++;
        }

        //copy remaining from right
        while(j < size2) {
            nums[k] = leftarray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int n = nums.length;
        mergesort(nums, 0, (n-1));
        for(int num: nums) {
            System.out.print(num + " ");
        }
        
    }    
}
