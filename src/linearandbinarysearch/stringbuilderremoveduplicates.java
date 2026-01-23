/*
 This program removes duplicate characters from a string using StringBuilder.
 It maintains the original order by tracking seen characters with a HashSet.
*/

import java.util.HashSet;

public class stringbuilderremoveduplicates {

    // Method to remove duplicates while preserving order
    static String removeDuplicates(String text) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        // Traverse each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Append only if character is not seen before
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "programming";

        System.out.println("Original String: " + input);

        String output = removeDuplicates(input);

        System.out.println("String after removing duplicates: " + output);
    }
}
