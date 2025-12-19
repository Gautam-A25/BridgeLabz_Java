import java.util.Scanner;

class NumberChecker2{

    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] getDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        for (int d : digits) {
            freq[d][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquares(digits));
        System.out.println("Is Harshad Number: " + isHarshad(number, digits));

        int[][] frequency = digitFrequency(digits);

        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + frequency[i][0] + ": " + frequency[i][1]);
        }

        input.close();
    }
}
