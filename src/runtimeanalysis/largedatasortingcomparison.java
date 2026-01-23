/*
 Compares Bubble Sort, Merge Sort, and Quick Sort
 for sorting large datasets by measuring execution time.
*/
package runtimeanalysis;

import java.util.Random;

public class largedatasortingcomparison {

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // Quick Sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Generate random array
    static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000};

        for (int size : sizes) {

            int[] base = generateArray(size);
            int[] arrBubble = base.clone();
            int[] arrMerge = base.clone();
            int[] arrQuick = base.clone();

            System.out.println("\nDataset Size: " + size);

            // Bubble Sort timing
            long startBubble = System.nanoTime();
            bubbleSort(arrBubble);
            long endBubble = System.nanoTime();
            System.out.println("Bubble Sort Time (ms): " +
                    (endBubble - startBubble) / 1_000_000.0);

            // Merge Sort timing
            long startMerge = System.nanoTime();
            mergeSort(arrMerge, 0, arrMerge.length - 1);
            long endMerge = System.nanoTime();
            System.out.println("Merge Sort Time  (ms): " +
                    (endMerge - startMerge) / 1_000_000.0);

            // Quick Sort timing
            long startQuick = System.nanoTime();
            quickSort(arrQuick, 0, arrQuick.length - 1);
            long endQuick = System.nanoTime();
            System.out.println("Quick Sort Time  (ms): " +
                    (endQuick - startQuick) / 1_000_000.0);
        }
    }
}
