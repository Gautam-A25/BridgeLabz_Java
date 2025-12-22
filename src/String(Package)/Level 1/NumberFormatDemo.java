import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateException(String text) {
        Integer.parseInt(text);
    }

    public static void handleException(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
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
