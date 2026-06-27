
import java.util.*;

public class FindWinners {

    public static void findwinners(int[][] matches) {
        //store each player's loss count
        HashMap<Integer, Integer> losscount = new HashMap<>();

        //traverse
        for(int[] match: matches) {
            
            int winner = match[0];
            int loser = match[1];

            //winner with 0 losses if not there
            losscount.putIfAbsent(winner, 0);

            //Incraese loser's loss count
            losscount.put(loser, losscount.getOrDefault(loser, 0) + 1);
        }

            //store players with 0 loss
            ArrayList<Integer> zeroloss = new ArrayList<>();
            //store players with 1 loss
            ArrayList<Integer> oneloss = new ArrayList<>();

            //ckeck eevry player
            for(int player: losscount.keySet()) {
                // get player's loss count
                int losses = losscount.get(player);

                //if player never lost
                if(losses == 0) zeroloss.add(player);

                //if player lost 1 match only
                else if(losses == 1) oneloss.add(player);
                    
            }

            //sort both lists
            Collections.sort(zeroloss);
            Collections.sort(oneloss);

            //print output
            System.out.println(zeroloss);
            System.out.println(oneloss);

    }
    
    public static void main(String[] args) {
        int[][] matches = { {1,3}, {2,3}, {3,6}, {5,6}, 
        {5,7}, {4,5}, {4,8}, {4,9}, {10,4}, {10,9} };

        findwinners(matches);
    }
}
