public class CharacterFrequency {

    public static void main(String[] args) {

        String str = "programming";

        char target = 'm';

        int count = 0;

        // Visit every character of string
        for (int i = 0; i < str.length(); i++) {

            // Increase count when target character is found
            if (str.charAt(i) == target) {

                count++;
            }
        }

        System.out.println("Frequency: " + count);
    }
}