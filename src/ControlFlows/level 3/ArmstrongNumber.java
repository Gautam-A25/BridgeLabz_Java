import java.util.Scanner;
class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int originalNumber = number;
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }
        System.out.println(sum == originalNumber ? "Armstrong Number" : "Not an Armstrong Number");
        input.close();
    }}
