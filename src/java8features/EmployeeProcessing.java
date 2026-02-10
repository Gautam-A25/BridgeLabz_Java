package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeProcessing {

    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        String getDepartment() {
            return department;
        }

        double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " (" + department + ") - $" + salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 95000),
                new Employee(2, "Bob", "Engineering", 85000),
                new Employee(3, "Charlie", "HR", 70000),
                new Employee(4, "David", "Engineering", 120000),
                new Employee(5, "Eve", "Finance", 90000)
        );

        // 1. Filter & Sort
        List<Employee> filtered =
                employees.stream()
                        .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .collect(Collectors.toList());

        System.out.println("Filtered & Sorted Employees:");
        filtered.forEach(System.out::println);

        // 2. Group & Average
        Map<String, Double> avgSalaryByDept =
                filtered.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println("\nAverage Salary by Department:");
        avgSalaryByDept.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }
}

