import java.util.Scanner;


class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int temp = number;
        int sum = 0;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        System.out.println(number % sum == 0 ? "Harshad Number" : "Not a Harshad Number");
        input.close();
    }
}
