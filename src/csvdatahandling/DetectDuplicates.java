package csvdatahandling;

import java.io.*;
import java.util.*;

public class DetectDuplicates {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV file name: ");
        String fileName = sc.nextLine();

        Set<String> ids = new HashSet<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine();

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String id = data[0];

            if (!ids.add(id)) {
                System.out.println("Duplicate record: " + line);
            }
        }

        br.close();
        sc.close();
    }
}
