/*
 This program reverses a given string using StringBuilder.
 It uses the built-in reverse() method for efficient string manipulation.
*/

public class stringbuilderreversestring {

    // Method to reverse a string using StringBuilder
    static String reverseString(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {

        String input = "hello";

        System.out.println("Original String: " + input);

        String reversed = reverseString(input);

        System.out.println("Reversed String: " + reversed);
    }
}
