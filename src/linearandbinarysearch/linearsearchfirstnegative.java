/*
 This program finds the first negative number in an array using Linear Search.
 It returns the index of the first negative number or -1 if none is found.
*/

public class linearsearchfirstnegative {

    // Method to find index of first negative number
    static int findFirstNegative(int[] arr) {

        // Traverse array from start
        for (int i = 0; i < arr.length; i++) {

            // Check if current element is negative
            if (arr[i] < 0) {
                return i;
            }
        }

        // No negative number found
        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = {5, 12, 7, -3, 9, -10};

        int index = findFirstNegative(numbers);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array");
        }
    }
}
