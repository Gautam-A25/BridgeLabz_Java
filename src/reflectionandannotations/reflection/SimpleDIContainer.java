package reflectionandannotations.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/*
 * Custom Inject Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class Engine {
    public void start() {
        System.out.println("Engine Started");
    }
}

class Car {

    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}

public class SimpleDIContainer {

    public static <T> T createInstance(Class<T> clazz) {

        try {

            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {

                if (field.isAnnotationPresent(Inject.class)) {

                    Object dependency =
                            field.getType().getDeclaredConstructor().newInstance();

                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }

            return instance;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Car car = createInstance(Car.class);

        car.drive();
    }
}
