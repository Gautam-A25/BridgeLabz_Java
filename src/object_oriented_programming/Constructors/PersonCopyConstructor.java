package object_oriented_programming.Constructors;

import java.util.Scanner;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonCopyConstructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = sc.nextInt();

        Person original = new Person(name, age);
        Person copy = new Person(original);

        original.display();
        copy.display();

        sc.close();
    }
}

