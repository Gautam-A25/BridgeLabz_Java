import java.util.Scanner;


class NaturalNumberSumFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= number; i++) {
                loopSum += i;
            }
            System.out.println("Sum using formula = " + formulaSum +
                               " and sum using for loop = " + loopSum);
        }
        input.close();
    }
}
