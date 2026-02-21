package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Apply Annotation
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Neha")
    void completeTask() {
        System.out.println("Task completed");
    }
}

// Step 3: Retrieve Annotation Using Reflection
public class CustomAnnotationExample {

    public static void main(String[] args) throws Exception {

        TaskManager manager = new TaskManager();

        Method method = manager.getClass().getMethod("completeTask");

        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        System.out.println("Priority: " + taskInfo.priority());
        System.out.println("Assigned To: " + taskInfo.assignedTo());
    }
}

