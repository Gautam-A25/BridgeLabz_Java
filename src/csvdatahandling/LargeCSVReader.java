package csvdatahandling;

import java.io.*;
import java.util.*;

public class LargeCSVReader {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter large CSV file name: ");
        String fileName = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine(); // skip header

        String line;
        int count = 0;
        int batchSize = 100;

        List<String> batch = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            batch.add(line);
            count++;

            if (batch.size() == batchSize) {
                System.out.println("Processed: " + count + " records");
                batch.clear();
            }
        }

        if (!batch.isEmpty()) {
            System.out.println("Processed: " + count + " records");
        }

        br.close();
        sc.close();
    }
}
