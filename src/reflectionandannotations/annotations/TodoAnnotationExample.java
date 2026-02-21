package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Step 2: Apply Annotation
class ProjectModule {

    @Todo(task = "Implement login feature", assignedTo = "Neha", priority = "HIGH")
    public void login() {}

    @Todo(task = "Add payment gateway", assignedTo = "Rahul")
    public void payment() {}

    @Todo(task = "Improve UI design", assignedTo = "Priya", priority = "LOW")
    public void updateUI() {}
}

// Step 3: Retrieve Using Reflection
public class TodoAnnotationExample {

    public static void main(String[] args) {

        Method[] methods = ProjectModule.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("---------------------------");
            }
        }
    }
}
