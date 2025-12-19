import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to calculate sum of n natural numbers using loop
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        if (n > 0) {
            int result = findSum(n);
            System.out.println("The sum of first " + n + " natural numbers is " + result);
        } else {
            System.out.println("Please enter a positive integer");
        }

        input.close();
    }
}
