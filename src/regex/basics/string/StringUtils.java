package javacollectionstreams.regex.basics.string;

public class StringUtils {

    // Reverses the given string
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Checks whether the string is a palindrome
    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Converts string to uppercase
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

