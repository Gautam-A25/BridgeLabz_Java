package designpattern;

import java.util.*;

interface Employee {
    void showDetails();
}

class Developer implements Employee {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Developer: " + name);
    }
}

class Manager implements Employee {

    private String name;
    private List<Employee> team = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void add(Employee emp) {
        team.add(emp);
    }

    public void showDetails() {
        System.out.println("Manager: " + name);
        for (Employee emp : team) {
            emp.showDetails();
        }
    }
}

public class CompositeDemo {
    public static void main(String[] args) {

        Developer dev1 = new Developer("Nehaa");
        Developer dev2 = new Developer("Riya");

        Manager manager = new Manager("Team Lead");
        manager.add(dev1);
        manager.add(dev2);

        manager.showDetails();
    }
}