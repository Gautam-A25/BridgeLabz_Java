import java.util.Scanner;

public class SubstringOccurrenceCounter {

    public static int countOccurrences(String text, String subText) {
        int count = 0;

        for (int i = 0; i <= text.length() - subText.length(); i++) {
            int j = 0;

            while (j < subText.length() && text.charAt(i + j) == subText.charAt(j)) {
                j++;
            }

            if (j == subText.length()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the main string:");
        String text = scanner.nextLine();
        System.out.println("Enter the substring to count:");
        String subText = scanner.next();
        scanner.close();
        System.out.println(countOccurrences(text, subText));
    }
}
