import java.util.Scanner;

public class ArrayValuesAndSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Infinite loop to take input
        while (true) {
            double value = input.nextDouble();

            // Break if value is 0 or negative
            if (value <= 0) {
                break;
            }

            // Break if array is full
            if (index == 10) {
                break;
            }

            numbers[index] = value;
            index++;
        }

        // Calculate total
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display numbers
        System.out.println("The numbers entered are:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        // Display total
        System.out.println("The total is " + total);

        input.close();
    }
}
