package javacollectionstreams.iostreams;
import java.io.*;
import java.util.Scanner;

/*
 Program: Save user details to file
 Uses BufferedReader for input and FileWriter for output
*/

public class UserToFile {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("user.txt");

            System.out.print("Enter name: ");
            String name = br.readLine();

            System.out.print("Enter age: ");
            String age = br.readLine();

            System.out.print("Enter favorite language: ");
            String lang = br.readLine();

            // Writing to file
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Language: " + lang + "\n");

            fw.close();
            System.out.println("Data saved to file!");

        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }
}

