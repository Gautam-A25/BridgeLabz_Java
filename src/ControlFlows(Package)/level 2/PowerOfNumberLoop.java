import java.util.Scanner;

public class PowerOfNumberLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int power = input.nextInt();

        if (number > 0 && power >= 0) {
            int result = 1;

            for (int i = 1; i <= power; i++) {
                result *= number;
            }

            System.out.println("The result is " + result);
        } else {
            System.out.println("Please enter positive integers");
        }

        input.close();
    }
}
