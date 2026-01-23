/*
 This program compares StringBuilder vs StringBuffer performance
 and FileReader vs InputStreamReader for reading a large file.
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class stringbufferbuilderandfilereadercomparison {

    // Compare StringBuilder and StringBuffer concatenation
    static void compareStringConcatenation() {

        int iterations = 1_000_000;
        String text = "hello";

        // StringBuilder test
        StringBuilder sb = new StringBuilder();
        long startBuilder = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // StringBuffer test
        StringBuffer sbuf = new StringBuffer();
        long startBuffer = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            sbuf.append(text);
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        System.out.println("StringBuilder Time (ns): " + builderTime);
        System.out.println("StringBuffer  Time (ns): " + bufferTime);
    }

    // Count words using FileReader
    static long countWordsUsingFileReader(String filePath) throws IOException {

        long wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        }
        return wordCount;
    }

    // Count words using InputStreamReader
    static long countWordsUsingInputStreamReader(String filePath) throws IOException {

        long wordCount = 0;

        try (
                FileInputStream fis = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        }
        return wordCount;
    }

    public static void main(String[] args) {

        // Part 1: StringBuilder vs StringBuffer
        System.out.println("=== String Concatenation Comparison ===");
        compareStringConcatenation();

        // File path for large file (e.g., 100MB)
        String filePath = "largefile.txt";

        try {
            // Part 2: FileReader
            long startFR = System.nanoTime();
            long wordsFR = countWordsUsingFileReader(filePath);
            long endFR = System.nanoTime();

            // Part 2: InputStreamReader
            long startISR = System.nanoTime();
            long wordsISR = countWordsUsingInputStreamReader(filePath);
            long endISR = System.nanoTime();

            System.out.println("\n=== File Reading Comparison ===");
            System.out.println("FileReader Word Count        : " + wordsFR);
            System.out.println("FileReader Time (ns)         : " + (endFR - startFR));

            System.out.println("InputStreamReader Word Count : " + wordsISR);
            System.out.println("InputStreamReader Time (ns)  : " + (endISR - startISR));

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
