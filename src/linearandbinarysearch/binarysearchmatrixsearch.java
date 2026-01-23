/*
 This program searches for a target value in a 2D sorted matrix using Binary Search.
 The matrix is treated as a flattened 1D array for efficient searching.
*/

public class binarysearchmatrixsearch {

    // Method to search target in 2D matrix
    static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        // Binary search on flattened matrix
        while (left <= right) {
            int mid = (left + right) / 2;

            // Convert 1D index to 2D indices
            int row = mid / cols;
            int col = mid % cols;

            // Check the middle element
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Target not found
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        boolean found = searchMatrix(matrix, target);

        if (found) {
            System.out.println("Target found in the matrix");
        } else {
            System.out.println("Target not found in the matrix");
        }
    }
}
