package collections;

import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees)
            map.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);

        for (String dept : map.keySet()) {
            System.out.print(dept + ": ");
            for (Employee e : map.get(dept))
                System.out.print(e.name + " ");
            System.out.println();
        }
    }
}

