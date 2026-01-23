/*
 Compares Linear Search and Binary Search performance
 for searching a target in a large dataset.
*/
package runtimeanalysis;

public class linearbinarysearchcomparison {

    // Linear Search
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int size = 1_000_000;
        int target = size - 1;

        int[] data = new int[size];

        // Fill array
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }

        // Linear Search timing
        long startLinear = System.nanoTime();
        linearSearch(data, target);
        long endLinear = System.nanoTime();

        // Binary Search timing
        long startBinary = System.nanoTime();
        binarySearch(data, target);
        long endBinary = System.nanoTime();

        // Display results
        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time (ms): " +
                (endLinear - startLinear) / 1_000_000.0);
        System.out.println("Binary Search Time (ms): " +
                (endBinary - startBinary) / 1_000_000.0);
    }
}
