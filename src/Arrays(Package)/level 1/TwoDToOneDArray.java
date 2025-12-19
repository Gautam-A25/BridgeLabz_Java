import java.util.Scanner;

public class TwoDToOneDArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input rows and columns
        int rows = input.nextInt();
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];

        // Take input for 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Create 1D array
        int[] array = new int[rows * columns];
        int index = 0;

        // Copy 2D array into 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index++] = matrix[i][j];
            }
        }

        // Display 1D array
        System.out.println("1D Array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        input.close();
    }
}
