import java.util.Scanner;


class PrimeNumber {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int number = input.nextInt();
        boolean isPrime = number > 1;


        for (int i = 2; i <= number / 2 && isPrime; i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }


        System.out.println(isPrime ? "Prime Number" : "Not a Prime Number");


        input.close();
    }
}
