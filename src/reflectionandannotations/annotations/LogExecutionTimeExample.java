package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

// Step 2: Apply Annotation
class PerformanceService {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 100000000; i++);
    }
}

// Step 3: Measure Execution Time Using Reflection
public class LogExecutionTimeExample {

    public static void main(String[] args) throws Exception {

        PerformanceService service = new PerformanceService();

        Method[] methods = PerformanceService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();

                method.invoke(service);

                long end = System.nanoTime();

                System.out.println("Method: " + method.getName());
                System.out.println("Execution Time: " + (end - start) + " ns");
                System.out.println("----------------------------");
            }
        }
    }
}
