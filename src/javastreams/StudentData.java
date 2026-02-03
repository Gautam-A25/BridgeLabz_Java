package javacollectionstreams.iostreams;
import java.io.*;
import java.util.Scanner;

/*
 Program: Store and retrieve student data using Data Streams
*/

public class StudentData {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"));

        System.out.print("Roll No: ");
        dos.writeInt(sc.nextInt());

        sc.nextLine();
        System.out.print("Name: ");
        dos.writeUTF(sc.nextLine());

        System.out.print("GPA: ");
        dos.writeDouble(sc.nextDouble());

        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));
        System.out.println("Roll: " + dis.readInt());
        System.out.println("Name: " + dis.readUTF());
        System.out.println("GPA: " + dis.readDouble());
        dis.close();
    }
}

