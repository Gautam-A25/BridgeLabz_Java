/*
 This program counts the occurrence of a specific word in a file using FileReader.
 BufferedReader is used to read the file line by line efficiently.
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class filereadercountwordoccurrence {

    public static void main(String[] args) {

        String filePath = "sample.txt";   // file to be read
        String targetWord = "java";       // word to search (case-insensitive)
        int count = 0;

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Create FileReader and BufferedReader
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Split line into words
                String[] words = line.split("\\s+");

                // Check each word
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            // Display result
            System.out.println("Word \"" + targetWord + "\" occurred " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                // Close resources
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}
