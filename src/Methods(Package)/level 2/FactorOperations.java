import java.util.Scanner;

class FactorOperations {

    public static int[] findFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    public static int sum(int[] array) {
        int s = 0;
        for (int i = 0; i < array.length; i++) s += array[i];
        return s;
    }

    public static int product(int[] array) {
        int p = 1;
        for (int i = 0; i < array.length; i++) p *= array[i];
        return p;
    }

    public static double sumOfSquares(int[] array) {
        double s = 0;
        for (int i = 0; i < array.length; i++) {
            s += Math.pow(array[i], 2);
        }
        return s;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int[] factors = findFactors(number);

        System.out.println(sum(factors));
        System.out.println(product(factors));
        System.out.println(sumOfSquares(factors));

        input.close();
    }
}
