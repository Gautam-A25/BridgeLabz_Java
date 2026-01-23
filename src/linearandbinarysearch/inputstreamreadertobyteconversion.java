/*
 This program converts a byte stream into a character stream using InputStreamReader.
 It reads a UTF-8 encoded file and prints its content line by line.
*/

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class inputstreamreadertobyteconversion {

    public static void main(String[] args) {

        String filePath = "sample.txt"; // file to be read

        // Try-with-resources to auto-close streams
        try (
                FileInputStream fis = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)
        ) {

            String line;

            // Read and print file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
