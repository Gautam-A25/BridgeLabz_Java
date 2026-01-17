import java.util.Scanner;


class DigitFrequency {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int number = input.nextInt();
        int[] frequency = new int[10];


        while (number != 0) {
            frequency[number % 10]++;
            number /= 10;
        }


        for (int i = 0; i < frequency.length; i++) {
            System.out.println(i + " " + frequency[i]);
        }


        input.close();
    }
}
