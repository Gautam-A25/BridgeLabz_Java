package reflectionandannotations.annotations;

// Parent class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class
class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class OverrideExample {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.makeSound();
    }
}
