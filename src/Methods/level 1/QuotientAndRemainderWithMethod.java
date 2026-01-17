import java.util.Scanner;

public class QuotientAndRemainderWithMethod {

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int divisor = input.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);

        System.out.println(
                "The Quotient is " + result[0] +
                        " and Reminder is " + result[1] +
                        " of two number " + number + " and " + divisor
        );

        input.close();
    }
}
