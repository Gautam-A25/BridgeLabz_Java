import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check for palindrome:");
        String input = scanner.next();
        scanner.close();

        System.out.println(isPalindrome(input));
    }
}
