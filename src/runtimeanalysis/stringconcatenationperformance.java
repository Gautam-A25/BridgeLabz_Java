/*
 Compares String, StringBuilder, and StringBuffer performance
 for concatenating a large number of strings.
*/
package runtimeanalysis;

public class stringconcatenationperformance {

    // Concatenation using String
    static void testString(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "hello";
        }
    }

    // Concatenation using StringBuilder
    static void testStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
    }

    // Concatenation using StringBuffer
    static void testStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
    }

    public static void main(String[] args) {

        int n = 10000; // change to 1000 / 100000 / 1000000 if needed

        // String timing
        long startString = System.nanoTime();
        testString(n);
        long endString = System.nanoTime();

        // StringBuilder timing
        long startBuilder = System.nanoTime();
        testStringBuilder(n);
        long endBuilder = System.nanoTime();

        // StringBuffer timing
        long startBuffer = System.nanoTime();
        testStringBuffer(n);
        long endBuffer = System.nanoTime();

        // Display results
        System.out.println("Operations Count: " + n);
        System.out.println("String Time (ms): " +
                (endString - startString) / 1_000_000.0);
        System.out.println("StringBuilder Time (ms): " +
                (endBuilder - startBuilder) / 1_000_000.0);
        System.out.println("StringBuffer Time (ms): " +
                (endBuffer - startBuffer) / 1_000_000.0);
    }
}
