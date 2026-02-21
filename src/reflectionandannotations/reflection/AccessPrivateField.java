package reflectionandannotations.reflection;

import java.lang.reflect.Field;

/*
 * Modify and retrieve private field using Reflection
 */
class Person {

    private int age = 20;
}

public class AccessPrivateField {

    public static void main(String[] args) {

        try {

            Person person = new Person();

            Class<?> clazz = person.getClass();

            Field ageField = clazz.getDeclaredField("age");

            // Make private field accessible
            ageField.setAccessible(true);

            // Modify value
            ageField.set(person, 30);

            // Retrieve value
            int updatedAge = (int) ageField.get(person);

            System.out.println("Updated Age: " + updatedAge);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
