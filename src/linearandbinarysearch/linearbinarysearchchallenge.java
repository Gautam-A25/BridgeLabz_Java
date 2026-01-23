/*
 This program demonstrates both Linear Search and Binary Search.
 Linear Search is used to find the first missing positive integer.
 Binary Search is used to find the index of a target number after sorting.
*/

import java.util.Arrays;

public class linearbinarysearchchallenge {

    // Method to find first missing positive integer using Linear Search logic
    static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Mark numbers present in range 1 to n
        boolean[] present = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n) {
                present[arr[i]] = true;
            }
        }

        // Find the first missing positive number
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        // If all numbers 1..n are present
        return n + 1;
    }

    // Method to perform Binary Search for a target value
    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = {3, 4, -1, 1};
        int target = 4;

        // Linear Search task
        int missing = findFirstMissingPositive(numbers);
        System.out.println("First missing positive integer: " + missing);

        // Sort array for Binary Search
        Arrays.sort(numbers);

        // Binary Search task
        int index = binarySearch(numbers, target);

        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target not found");
        }
    }
}
