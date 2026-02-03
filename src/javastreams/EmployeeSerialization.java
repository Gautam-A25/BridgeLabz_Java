package javacollectionstreams.iostreams;
import java.io.*;
import java.util.*;

/*
 Program: Employee Serialization
 Stores and retrieves employee objects
*/

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Dept: ");
            String dept = sc.nextLine();

            System.out.print("Salary: ");
            double sal = sc.nextDouble();

            list.add(new Employee(id, name, dept, sal));
        }

        // Serialization
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }

        // Deserialization
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("employees.dat"))) {
            List<Employee> data = (List<Employee>) ois.readObject();

            for (Employee e : data) {
                System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
            }

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}
