import java.util.Scanner;

public class LexicoComparison {

    public static int compareStrings(String first, String second) {
        int minLength = first.length() < second.length() ? first.length() : second.length();

        for (int i = 0; i < minLength; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.charAt(i) - second.charAt(i);
            }
        }

        return first.length() - second.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two strings to compare:");
        String first = scanner.next();
        String second = scanner.next();
        scanner.close();
        
        int result = compareStrings(first, second);

        if (result < 0) {
            System.out.println(first + " comes before " + second);
        } else if (result > 0) {
            System.out.println(first + " comes after " + second);
        } else {
            System.out.println("Both strings are equal");
        }
    }
}
