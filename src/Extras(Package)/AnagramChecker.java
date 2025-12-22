import java.util.Scanner;

public class AnagramChecker {

    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int[] count = new int[256];

        for (int i = 0; i < first.length(); i++) {
            count[first.charAt(i)]++;
            count[second.charAt(i)]--;
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two strings to check for anagrams:");
        String first = scanner.next();
        String second = scanner.next();
        scanner.close();
        System.out.println(areAnagrams(first, second));
    }
}
