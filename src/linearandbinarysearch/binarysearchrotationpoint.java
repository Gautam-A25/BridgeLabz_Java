/*
 This program finds the rotation point (index of the smallest element)
 in a rotated sorted array using Binary Search.
*/

public class binarysearchrotationpoint {

    // Method to find index of smallest element (rotation point)
    static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search
        while (left < right) {
            int mid = (left + right) / 2;

            // If mid element is greater than rightmost,
            // smallest element lies in right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Otherwise, smallest element lies in left half (including mid)
            else {
                right = mid;
            }
        }

        // left == right is the index of smallest element
        return left;
    }

    public static void main(String[] args) {

        int[] rotatedArray = {15, 18, 2, 3, 6, 12};

        int rotationIndex = findRotationPoint(rotatedArray);

        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + rotatedArray[rotationIndex]);
    }
}
