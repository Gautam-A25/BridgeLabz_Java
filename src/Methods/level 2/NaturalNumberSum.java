import java.util.Scanner;

class NaturalNumberSum {

    public static int recursiveSum(int n) {
        if (n == 0) return 0;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        if (n <= 0) return;

        System.out.println(recursiveSum(n));
        System.out.println(formulaSum(n));

        input.close();
    }
}
