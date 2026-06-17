public class PalindromeString {

    public static void main(String[] args) {

        String str = "madam";

        // Stores reversed version of string
        String reversed = "";

        // Reverse the string
        for (int i = str.length() - 1; i >= 0; i--) {

            reversed += str.charAt(i);
        }

        // Compare original and reversed string
        if (str.equals(reversed)) {

            System.out.println("Palindrome String");
        } else {

            System.out.println("Not a Palindrome String");
        }
    }
}