import java.util.Scanner;
class DivisibleByFive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.println("Is the number " + number + " divisible by 5? " + (number % 5 == 0));
        input.close();
    }
}
