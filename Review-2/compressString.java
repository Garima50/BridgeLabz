
public class compressString {
    public static void main(String[] args) {

        String str = "aaabbcc";
        StringBuilder res = new StringBuilder(); // to store compressed string
        int count = 1; // to keep count of the char
        
        for(int i = 1; i < str.length(); i++){ 
            if(str.charAt(i) == str.charAt(i-1)) {  //compare each char from the previous
                count++;
            } else {
                res.append(str.charAt(i-1)).append(count); // diff char -> add prev char count to res
                count = 1; // reset count
            }
        }
        res.append(str.charAt(str.length()-1)).append(count); // to add the last char with count
        System.out.println(res);
        
    }
}
