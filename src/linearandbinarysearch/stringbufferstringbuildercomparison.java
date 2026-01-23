/*
 This program compares the performance of StringBuffer and StringBuilder
 for string concatenation by appending a large number of strings.
*/

public class stringbufferstringbuildercomparison {

    public static void main(String[] args) {

        int iterations = 1_000_000;

        // StringBuffer performance test
        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // StringBuilder performance test
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // Display results
        System.out.println("Time taken by StringBuffer  (ns): " + bufferTime);
        System.out.println("Time taken by StringBuilder (ns): " + builderTime);
    }
}
