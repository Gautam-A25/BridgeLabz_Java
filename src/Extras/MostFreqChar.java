import java.util.Scanner;

public class MostFreqChar {

    public static char findMostFrequentCharacter(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        char result = text.charAt(0);
        int maxCount = frequency[result];

        for (int i = 1; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] > maxCount) {
                maxCount = frequency[ch];
                result = ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.next();
        scanner.close();
        System.out.println(findMostFrequentCharacter(input));
    }
}
