package designpattern;

interface FactoryShape {
    void draw();
}

class Circle implements FactoryShape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements FactoryShape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class ShapeFactory {

    public static FactoryShape getShape(String type) {
        if (type.equalsIgnoreCase("circle"))
            return new Circle();
        else if (type.equalsIgnoreCase("rectangle"))
            return new Rectangle();
        else
            return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {

        FactoryShape shape1 = ShapeFactory.getShape("circle");
        shape1.draw();

        FactoryShape shape2 = ShapeFactory.getShape("rectangle");
        shape2.draw();
    }
}