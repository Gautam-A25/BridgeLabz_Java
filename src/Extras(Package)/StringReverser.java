import java.util.Scanner;

public class StringReverser {

    public static String reverseString(String text) {
        String result = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            result = result + text.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse:");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println(reverseString(input));
    }
}
