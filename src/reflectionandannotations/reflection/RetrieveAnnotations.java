package reflectionandannotations.reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

/*
 * Custom Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

/*
 * Apply annotation to a class
 */
@Author(name = "Sudechha Chakraborty")
class SampleClass {
}

public class RetrieveAnnotations {

    public static void main(String[] args) {

        try {

            Class<?> clazz = SampleClass.class;

            if (clazz.isAnnotationPresent(Author.class)) {

                Author author = clazz.getAnnotation(Author.class);

                System.out.println("Author Name: " + author.name());
            }
            else {
                System.out.println("No Author annotation found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

