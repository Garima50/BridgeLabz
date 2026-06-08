public class Reverseword {
    public static void main(String[] args) {
        String s = "Java is awesome";

        String[] w = s.split(" ");

        for(String str: w) {
            String rev = new StringBuilder(str).reverse().toString();
            System.out.println(rev + " ");
        }
        
    }
}