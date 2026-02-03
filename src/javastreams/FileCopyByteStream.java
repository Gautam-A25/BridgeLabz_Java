package javastreams;

import java.io.*;

public class FileCopyByteStream {
    public static void main(String[] args) {
        File source = new File("src/javastreams/source.txt");
        File dest = new File("src/javastreams/destination.txt");

        if (!source.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
