import java.util.Scanner;

public class DuplicateRemover {

    public static String removeDuplicates(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (result.indexOf(current) == -1) {
                result = result + current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println(removeDuplicates(input));
    }
}
