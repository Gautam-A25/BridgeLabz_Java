package reflectionandannotations.reflection;

import java.lang.reflect.Constructor;

/*
 * Create object dynamically using Reflection
 */
class Student {

    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {

    public static void main(String[] args) {

        try {

            Class<?> clazz = Class.forName("Student");

            Constructor<?> constructor = clazz.getDeclaredConstructor();

            Object studentObject = constructor.newInstance();

            Student student = (Student) studentObject;

            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
