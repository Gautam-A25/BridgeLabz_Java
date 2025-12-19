import java.util.Scanner;

class NumberChecker {

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

    public static boolean isDuck(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    public static int[] largestTwo(int[] digits) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > max1) {
                max2 = max1;
                max1 = d;
            } else if (d > max2 && d != max1) {
                max2 = d;
            }
        }
        return new int[]{max1, max2};
    }

    public static int[] smallestTwo(int[] digits) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < min1) {
                min2 = min1;
                min1 = d;
            } else if (d < min2 && d != min1) {
                min2 = d;
            }
        }
        return new int[]{min1, min2};
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Number of digits: " + countDigits(number));
        System.out.println("Is Duck Number: " + isDuck(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(number, digits));

        int[] largest = largestTwo(digits);
        int[] smallest = smallestTwo(digits);

        System.out.println("Largest two digits: " + largest[0] + " " + largest[1]);
        System.out.println("Smallest two digits: " + smallest[0] + " " + smallest[1]);

        input.close();
    }
}
