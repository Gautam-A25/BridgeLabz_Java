import java.util.Scanner;

public class StringIndexException {

    public static void generateException(String text) {
        text.charAt(text.length());
    }

    public static void handleException(String text) {
        try {
            text.charAt(text.length());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        try {
            generateException(text);
        } catch (Exception e) {
            handleException(text);
        }
    }
}
