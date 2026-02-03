package javacollectionstreams.iostreams;
import java.io.*;
import java.util.Scanner;

/*
 Program: Print lines containing "error"
*/

public class ErrorFinder {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("error")) {
                System.out.println(line);
            }
        }
        br.close();
    }
}
