package csvdatahandling;

import java.io.*;
import java.util.*;

public class StudentCSV {

    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return id + " - " + name + " - " + age;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV file name: ");
        String fileName = sc.nextLine();

        List<Student> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine(); // skip header

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            list.add(new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2])
            ));
        }

        br.close();

        System.out.println("Students List:");
        for (Student s : list) {
            System.out.println(s);
        }

        sc.close();
    }
}
