/*
 This program concatenates an array of strings efficiently using StringBuffer.
 StringBuffer is mutable, so it avoids creating multiple string objects.
*/

public class stringbufferconcatenatestrings {

    // Method to concatenate strings using StringBuffer
    static String concatenateStrings(String[] arr) {
        StringBuffer buffer = new StringBuffer();

        // Append each string to StringBuffer
        for (String str : arr) {
            buffer.append(str);
        }

        // Convert StringBuffer to String
        return buffer.toString();
    }

    public static void main(String[] args) {

        String[] words = {"Java", " ", "is", " ", "powerful"};

        System.out.println("Original Strings:");
        for (String word : words) {
            System.out.print(word);
        }
        System.out.println();

        // Concatenate strings
        String result = concatenateStrings(words);

        System.out.println("Concatenated String:");
        System.out.println(result);
    }
}
