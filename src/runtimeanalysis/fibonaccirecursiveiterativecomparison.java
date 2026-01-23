/*
 Compares Recursive and Iterative Fibonacci computation
 by measuring execution time for both approaches.
*/
package runtimeanalysis;

public class fibonaccirecursiveiterativecomparison {

    // Recursive Fibonacci
    static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        int n = 30; // try with 10 / 30 (avoid large value for recursion)

        // Recursive timing
        long startRec = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        long endRec = System.nanoTime();

        // Iterative timing
        long startItr = System.nanoTime();
        int itrResult = fibonacciIterative(n);
        long endItr = System.nanoTime();

        // Display results
        System.out.println("Fibonacci Number (n): " + n);
        System.out.println("Recursive Result: " + recResult);
        System.out.println("Iterative Result: " + itrResult);

        System.out.println("Recursive Time (ms): " +
                (endRec - startRec) / 1_000_000.0);
        System.out.println("Iterative Time (ms): " +
                (endItr - startItr) / 1_000_000.0);
    }
}
