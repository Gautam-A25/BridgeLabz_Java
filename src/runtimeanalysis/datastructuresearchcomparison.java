/*
 Compares search performance of Array, HashSet, and TreeSet
 by measuring lookup time on large datasets.
*/
package runtimeanalysis;

import java.util.HashSet;
import java.util.TreeSet;

public class datastructuresearchcomparison {

    // Linear search in array
    static boolean arraySearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int size = 1_000_000;
        int target = size - 1;

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Fill data structures
        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        // Array search timing
        long startArray = System.nanoTime();
        arraySearch(array, target);
        long endArray = System.nanoTime();

        // HashSet search timing
        long startHash = System.nanoTime();
        hashSet.contains(target);
        long endHash = System.nanoTime();

        // TreeSet search timing
        long startTree = System.nanoTime();
        treeSet.contains(target);
        long endTree = System.nanoTime();

        // Display results
        System.out.println("Dataset Size: " + size);
        System.out.println("Array Search Time (ms): " +
                (endArray - startArray) / 1_000_000.0);
        System.out.println("HashSet Search Time (ms): " +
                (endHash - startHash) / 1_000_000.0);
        System.out.println("TreeSet Search Time (ms): " +
                (endTree - startTree) / 1_000_000.0);
    }
}
