package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

// Step 1: Repeatable Annotation
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 2: Container Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

// Step 3: Apply Multiple Annotations
class Project {

    @BugReport(description = "Null pointer possible")
    @BugReport(description = "Incorrect logic in calculation")
    void calculate() {
        System.out.println("Calculating...");
    }
}

// Step 4: Retrieve All Annotations
public class RepeatableAnnotationExample {

    public static void main(String[] args) throws Exception {

        Method method = Project.class.getMethod("calculate");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}

