package javacollectionstreams.exceptionhandling.level2;
import java.io.*;
import java.util.*;

/*
 This class reads multiple files using try-with-resources.
 It ensures that all files are closed automatically.
*/
class FileProcessor {

    void processFiles(List<String> filePaths) {

        // Looping through each file path
        for (String path : filePaths) {

            // try-with-resources block
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                String line;
                System.out.println("Contents of " + path + ":");

                // Reading file line by line
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
            }
        }
    }

    public static void main(String[] args) {

        // Taking user input
        Scanner sc = new Scanner(System.in);
        List<String> files = new ArrayList<>();

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Reading file names from user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter file path: ");
            files.add(sc.nextLine());
        }

        FileProcessor fp = new FileProcessor();
        fp.processFiles(files);
    }
}


