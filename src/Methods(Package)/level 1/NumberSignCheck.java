import java.util.Scanner;

public class NumberSignCheck {

    // Method to check number sign
    public static int checkNumber(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int result = checkNumber(number);

        if (result == 1) {
            System.out.println("The number is positive");
        } else if (result == -1) {
            System.out.println("The number is negative");
        } else {
            System.out.println("The number is zero");
        }

        input.close();
    }
}
