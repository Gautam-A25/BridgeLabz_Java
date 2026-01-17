import java.util.Scanner;

public class CaseToggle{

    public static String toggleCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                result = result + (char) (ch - 32);
            } else if (ch >= 'A' && ch <= 'Z') {
                result = result + (char) (ch + 32);
            } else {
                result = result + ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to toggle case:");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println(toggleCase(input));
    }
}
