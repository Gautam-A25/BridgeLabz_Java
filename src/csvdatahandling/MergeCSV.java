package csvdatahandling;

import java.io.*;
import java.util.*;

public class MergeCSV {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first CSV: ");
        String file1 = sc.nextLine();

        System.out.print("Enter second CSV: ");
        String file2 = sc.nextLine();

        System.out.print("Enter output CSV: ");
        String output = sc.nextLine();

        Map<String, String[]> map = new HashMap<>();

        // Read first file
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        br1.readLine();
        String line;

        while ((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            map.put(data[0], data);
        }
        br1.close();

        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        bw.write("ID,Name,Age,Marks,Grade");
        bw.newLine();

        br2.readLine();

        while ((line = br2.readLine()) != null) {
            String[] data2 = line.split(",");
            String id = data2[0];

            if (map.containsKey(id)) {
                String[] data1 = map.get(id);
                bw.write(id + "," + data1[1] + "," + data1[2] + "," +
                        data2[1] + "," + data2[2]);
                bw.newLine();
            }
        }

        br2.close();
        bw.close();
        sc.close();

        System.out.println("Merged file created!");
    }
}
