/*
 Compares FileReader and InputStreamReader performance
 while reading a large file by measuring execution time.
*/
package runtimeanalysis;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class largefilereadingefficiency {

    // Read file using FileReader
    static void readUsingFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        while (br.readLine() != null) {
            // reading line by line
        }

        br.close();
        fr.close();
    }

    // Read file using InputStreamReader
    static void readUsingInputStreamReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        while (br.readLine() != null) {
            // reading line by line
        }

        br.close();
        isr.close();
        fis.close();
    }

    public static void main(String[] args) {

        String filePath = "largefile.txt"; // large file path (e.g., 100MB / 500MB)

        try {
            // FileReader timing
            long startFR = System.nanoTime();
            readUsingFileReader(filePath);
            long endFR = System.nanoTime();

            // InputStreamReader timing
            long startISR = System.nanoTime();
            readUsingInputStreamReader(filePath);
            long endISR = System.nanoTime();

            // Display results
            System.out.println("FileReader Time (ms): " +
                    (endFR - startFR) / 1_000_000.0);
            System.out.println("InputStreamReader Time (ms): " +
                    (endISR - startISR) / 1_000_000.0);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
