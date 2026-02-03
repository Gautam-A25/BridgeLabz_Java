package javacollectionstreams.iostreams;
import java.io.*;
import java.util.Scanner;

/*
 Program: Image to ByteArray and back
*/

public class ImageByteArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter image file name: ");
        String img = sc.nextLine();

        FileInputStream fis = new FileInputStream(img);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int data;
        while ((data = fis.read()) != -1) {
            baos.write(data);
        }

        byte[] imageBytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream("copy_" + img);

        while ((data = bais.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();
        System.out.println("Image copied successfully!");
    }
}

