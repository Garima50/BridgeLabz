public class CountVowels {

    public static void main(String[] args) {

        String str = "Programming";

        int count = 0;

        // Convert string to lowercase for easy comparison
        str = str.toLowerCase();

        // Check every character
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check if character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {

                count++;
            }
        }

        System.out.println("Number of Vowels: " + count);
    }
}