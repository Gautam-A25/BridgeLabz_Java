package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Step 2: Apply Annotation
class Service {

    @ImportantMethod
    public void criticalTask() {
        System.out.println("Executing critical task");
    }

    @ImportantMethod(level = "LOW")
    public void minorTask() {
        System.out.println("Executing minor task");
    }

    public void normalTask() {
        System.out.println("Executing normal task");
    }
}

// Step 3: Retrieve Using Reflection
public class ImportantMethodExample {

    public static void main(String[] args) {

        Method[] methods = Service.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation =
                        method.getAnnotation(ImportantMethod.class);

                System.out.println("Method: " + method.getName());
                System.out.println("Level: " + annotation.level());
                System.out.println("------------------------");
            }
        }
    }
}

