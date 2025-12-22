import java.util.Scanner;

public class StringLengthFinder {

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        int customLength = findLength(text);
        int builtInLength = text.length();

        System.out.println(customLength + " " + builtInLength);
    }
}
