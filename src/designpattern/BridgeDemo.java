package designpattern;

// Implementor
interface Color {
    void applyColor();
}

class Red implements Color {
    public void applyColor() {
        System.out.println("Red Color");
    }
}

class Blue implements Color {
    public void applyColor() {
        System.out.println("Blue Color");
    }
}

// Abstraction
abstract class Shape {   // ✅ FIXED NAME
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Concrete Shapes
class BridgeCircle extends Shape {

    public BridgeCircle(Color color) {
        super(color);
    }

    void draw() {
        System.out.print("Circle filled with ");
        color.applyColor();
    }
}

class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    void draw() {
        System.out.print("Square filled with ");
        color.applyColor();
    }
}

public class BridgeDemo {
    public static void main(String[] args) {

        Shape redCircle = new BridgeCircle(new Red());
        redCircle.draw();

        Shape blueSquare = new Square(new Blue());
        blueSquare.draw();
    }
}