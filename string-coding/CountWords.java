public class CountWords {

    public static void main(String[] args) {

        String str = "Java is easy to learn";

        // Remove extra spaces from start and end
        str = str.trim();

        // Split string wherever space occurs
        String[] words = str.split("\\s+");

        System.out.println("Total Words: " + words.length);
    }
}