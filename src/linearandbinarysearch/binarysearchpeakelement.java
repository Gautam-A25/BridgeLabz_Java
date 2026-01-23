/*
 This program finds a peak element in an array using Binary Search.
 A peak element is greater than its immediate neighbors.
*/

public class binarysearchpeakelement {

    // Method to find index of a peak element
    static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search
        while (left <= right) {
            int mid = (left + right) / 2;

            // Check left neighbor (handle boundary)
            boolean leftOk = (mid == 0) || (arr[mid] > arr[mid - 1]);
            // Check right neighbor (handle boundary)
            boolean rightOk = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            // If both conditions satisfy, mid is a peak
            if (leftOk && rightOk) {
                return mid;
            }

            // If left neighbor is greater, move to left half
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Otherwise, move to right half
            else {
                left = mid + 1;
            }
        }

        // Should not reach here for valid input
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakElement(arr);

        if (peakIndex != -1) {
            System.out.println("Peak element found at index: " + peakIndex);
            System.out.println("Peak element value: " + arr[peakIndex]);
        } else {
            System.out.println("No peak element found");
        }
    }
}
