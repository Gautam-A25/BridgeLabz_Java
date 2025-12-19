import java.util.Scanner;

class NumberAnalysis {

    public static boolean isPositive(int n) {
        return n > 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();

            if (isPositive(numbers[i])) {
                System.out.println(isEven(numbers[i]));
            } else {
                System.out.println("Negative");
            }
        }

        System.out.println(compare(numbers[0], numbers[numbers.length - 1]));

        input.close();
    }
}
