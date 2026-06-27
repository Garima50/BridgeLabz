
import java.util.*;

public class NumberOfBoomerangs {

    public static int numOfBoomerangs(int[][] points) {

        //total count
        int totalBoomerangs = 0;

        //take as center point
        for(int i = 0; i < points.length; i++) {

            //to store dist. & freq
            HashMap<Integer, Integer> disMap = new HashMap<>();
            //compare current point with other
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;

                //diff bw x coordinates
                int dx = points[i][0] - points[j][0];
                //diff bw y coordinates
                int dy = points[i][1] - points[j][1];

                //square distance
                int distance = dx * dx + dy * dy;

                //increase freq of dis
                disMap.put(distance, disMap.getOrDefault(distance, 0) + 1);
            }
            //traverse the dist freq.
            for(int count: disMap.values()) {
                //if 2 or more hve same dis -> they can be boomergs
                if (count > 1){
                    totalBoomerangs += count * (count - 1);
                }
            }
        }
        return totalBoomerangs;
    }

    public static void main(String[] args) {
        
        int[][] points = { {0,0}, {1,0}, {2,0} };
        System.out.println(numOfBoomerangs(points));
        
    }
    
}
