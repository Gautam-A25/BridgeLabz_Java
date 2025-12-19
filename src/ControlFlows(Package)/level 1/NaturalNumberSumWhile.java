import java.util.Scanner;


class NaturalNumberSumWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;
            int loopSum = 0;
            int i = 1;
            while (i <= number) {
                loopSum += i;
                i++;
            }
            System.out.println("Sum using formula = " + formulaSum +
                               " and sum using while loop = " + loopSum);
        }
        input.close();
    }
}
