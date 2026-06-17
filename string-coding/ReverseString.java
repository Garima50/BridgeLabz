public class ReverseString {

    public static void main(String[] args) {

        String str = "Garima";

        // Used to store reversed string
        String reversed = "";

        // Traverse string from last character to first
        for (int i = str.length() - 1; i >= 0; i--) {

            // Add current character to reversed string
            reversed += str.charAt(i);
        }

        System.out.println("Reversed String: " + reversed);
    }
}