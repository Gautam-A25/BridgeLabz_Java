package javacollectionstreams.iostreams;
import java.io.*;
import java.util.Scanner;

/*
 Program: Convert uppercase to lowercase
*/

public class UpperToLower {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file: ");
        String src = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(src));
        BufferedWriter bw = new BufferedWriter(new FileWriter("lowercase.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line.toLowerCase());
            bw.newLine();
        }

        br.close();
        bw.close();
        System.out.println("Converted successfully!");
    }
}

