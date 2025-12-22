import java.util.Scanner;

public class CharRemover {

    public static String removeCharacter(String text, char target) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != target) {
                result = result + text.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.nextLine();
        char target = scanner.next().charAt(0);
        scanner.close();
        System.out.println(removeCharacter(text, target));
    }
}
