
//import java.util.*;

public class SearchtwoDMatrix {

    public static boolean search(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0; //starting index
        int right = rows * cols -1;

        while(left <= right) {
            //middle index formula
            int mid = left + (right - left) / 2;
            //row index
            int row =  mid / cols;
            //col index
            int col = mid % cols;
            //middle value
            int value = matrix[row][col];

            //compare with target
            if(value == target) return true;
            //if target greater, left moves towards right
            else if(value < target) left = mid + 1;

            //if target is less, right moves to left side
            else right = mid - 1; 

        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = { {1,3,5,7},
                           {10,11,16,20}, 
                           {23,30,34,60} };
        System.out.println(search(matrix, 3));
    }
}
