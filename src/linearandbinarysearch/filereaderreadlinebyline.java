/*
 This program reads a text file line by line using FileReader.
 BufferedReader is used for efficient line-by-line reading.
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class filereaderreadlinebyline {

    public static void main(String[] args) {

        String filePath = "sample.txt"; // file to be read

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Create FileReader object
            fileReader = new FileReader(filePath);

            // Wrap FileReader with BufferedReader
            bufferedReader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

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
