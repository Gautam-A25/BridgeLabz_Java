import java.util.Scanner;


class ReverseNumberArray {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int number = input.nextInt();
        int temp = number;
        int count = 0;


        while (temp > 0) {
            count++;
            temp /= 10;
        }


        int[] digits = new int[count];
        temp = number;


        for (int i = 0; i < digits.length; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }


        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }


        input.close();
    }
}
