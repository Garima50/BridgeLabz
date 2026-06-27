
import java.util.*;

public class BrickWall {

    public static int leastbricks(int[][] wall) {

        //store edge position and its freq 
        HashMap<Integer, Integer> map = new HashMap<>();
        //max count of any edge
        int maxEdgeCount  = 0;

        //traverse row of wall
        for(int i = 0; i < wall.length; i++) {
            //curr edge position
            int edgePosition = 0;

            //not counting last wall coz its boundary
            for(int j = 0; j < wall[i].length -1; j++){
                // add current brick width
                edgePosition += wall[i][j];
                //increase freq of this edge pos.
                map.put(edgePosition, map.getOrDefault(edgePosition, 0) + 1);

                //update the maxcount 
                maxEdgeCount = Math.max(maxEdgeCount, map.get(edgePosition));
            }
        }
        //minimum bricks = total rows - max common freq of edge
        return wall.length - maxEdgeCount;

    }
    public static void main(String[] args) {
        int[][] wall = {
            {1,2,2,1}, {3,1,2}, {1,3,2}, {2,4}, {3,1,2}, {1,3,1,1} };
        System.out.println(leastbricks(wall));
        
    }
}
