import java.util.Scanner;

class NumberChecker5 {

    public static int[] getFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int idx = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[idx++] = i;
        }

        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int max = 1;
        for (int i = 0; i < factors.length - 1; i++) {
            max = Math.max(max, factors[i]);
        }
        return max;
    }

    public static int sum(int[] factors) {
        int s = 0;
        for (int f : factors) s += f;
        return s;
    }

    public static int product(int[] factors) {
        int p = 1;
        for (int f : factors) p *= f;
        return p;
    }

    public static double cubeProduct(int[] factors) {
        double p = 1;
        for (int f : factors) {
            p *= Math.pow(f, 3);
        }
        return p;
    }

    public static boolean isPerfect(int number, int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length - 1; i++) {
            sum += factors[i];
        }
        return sum == number;
    }

    public static boolean isAbundant(int number, int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length - 1; i++) {
            sum += factors[i];
        }
        return sum > number;
    }

    public static boolean isDeficient(int number, int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length - 1; i++) {
            sum += factors[i];
        }
        return sum < number;
    }

    public static boolean isStrong(int number) {
        int temp = number;
        int sum = 0;

        while (temp > 0) {
            int d = temp % 10;
            int fact = 1;
            for (int i = 1; i <= d; i++) fact *= i;
            sum += fact;
            temp /= 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int[] factors = getFactors(number);

        System.out.println("greatest Factor: " + greatestFactor(factors));
        System.out.println("sum: " + sum(factors));
        System.out.println("product: " + product(factors));
        System.out.println("cube Product: " + cubeProduct(factors));
        System.out.println("is Perfect: " + isPerfect(number, factors));
        System.out.println("is Abundant: " + isAbundant(number, factors));
        System.out.println("is Deficient: " + isDeficient(number, factors));
        System.out.println("is Strong: " + isStrong(number));
        input.close();
    }
}
