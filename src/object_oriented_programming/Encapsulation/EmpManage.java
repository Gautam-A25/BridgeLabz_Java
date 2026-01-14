package object_oriented_programming.Encapsulation;
import java.util.*;

interface Department {
    void assignDepartment(String name);
    String getDepartmentDetails();
}

abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public void assignDepartment(String name) {
        this.department = name;
    }

    public String getDepartmentDetails() {
        return department;
    }

    abstract double calculateSalary();

    void displayDetails() {
        System.out.println(employeeId + " " + name + " " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    double calculateSalary() {
        return getBaseSalary();
    }
}

class PartTimeEmployee extends Employee {
    private int hours;

    PartTimeEmployee(int id, String name, double rate, int hours) {
        super(id, name, rate);
        this.hours = hours;
    }

    double calculateSalary() {
        return getBaseSalary() * hours;
    }
}

public class EmpManage {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(1, "Aayush", 50000));
        employees.add(new PartTimeEmployee(2, "Rahul", 500, 40));

        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}
