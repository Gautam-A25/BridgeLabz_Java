package designpattern;

import java.util.HashMap;

// Flyweight
class Font {
    private String type;

    public Font(String type) {
        this.type = type;
    }

    public void print(String character) {
        System.out.println("Character: " + character + " with Font: " + type);
    }
}

// Flyweight Factory
class FontFactory {
    private static HashMap<String, Font> fontMap = new HashMap<>();

    public static Font getFont(String type) {
        if (!fontMap.containsKey(type)) {
            fontMap.put(type, new Font(type));
        }
        return fontMap.get(type);
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {

        Font arial = FontFactory.getFont("Arial");
        arial.print("A");

        Font arial2 = FontFactory.getFont("Arial");
        arial2.print("B");

        System.out.println(arial == arial2); // true
    }
}
