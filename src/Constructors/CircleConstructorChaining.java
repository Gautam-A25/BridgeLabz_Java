package Constructors;

import java.util.Scanner;

class Circle {
    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }
}

public class CircleConstructorChaining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Circle c1 = new Circle();
        c1.display();

        double r = sc.nextDouble();
        Circle c2 = new Circle(r);
        c2.display();

        sc.close();
    }
}

