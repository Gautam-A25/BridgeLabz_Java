package reflectionandannotations.reflection;

import java.lang.reflect.Method;

/*
 * Measure execution time of methods using Reflection
 */
class Task {

    public void performTask() {

        for (int i = 0; i < 1000000; i++) {
            // Simulating work
        }

        System.out.println("Task Completed");
    }
}

public class MethodExecutionTimer {

    public static void executeWithTiming(Object object,
                                         String methodName) {

        try {

            Method method =
                    object.getClass().getMethod(methodName);

            long startTime = System.nanoTime();

            method.invoke(object);

            long endTime = System.nanoTime();

            System.out.println("Execution Time: "
                    + (endTime - startTime) + " ns");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Task task = new Task();

        executeWithTiming(task, "performTask");
    }
}

