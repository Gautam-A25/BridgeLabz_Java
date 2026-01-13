package CoreProgramming.ClassAndObject.level2;

import java.util.Scanner;

class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker(text);
        checker.displayResult();

        sc.close();
    }
}
