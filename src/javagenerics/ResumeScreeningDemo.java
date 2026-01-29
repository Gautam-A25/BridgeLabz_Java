package javagenerics;
import java.util.ArrayList;
import java.util.List;

/*
 ============================================================
  AI-DRIVEN RESUME SCREENING SYSTEM
 ============================================================
*/

// Abstract JobRole
abstract class JobRole {
    public abstract void evaluateResume();
}

// Job role implementations
class SoftwareEngineer extends JobRole {
    public void evaluateResume() {
        System.out.println("Evaluating Software Engineer Resume");
    }
}

class DataScientist extends JobRole {
    public void evaluateResume() {
        System.out.println("Evaluating Data Scientist Resume");
    }
}

class ProductManager extends JobRole {
    public void evaluateResume() {
        System.out.println("Evaluating Product Manager Resume");
    }
}

/*
 * Generic Resume class
 */
class Resume<T extends JobRole> {

    private T role;

    public Resume(T role) {
        this.role = role;
    }

    public T getRole() {
        return role;
    }
}

/*
 * Screening pipeline using wildcard
 */
class ResumeScreeningPipeline {

    public static void screenAll(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.evaluateResume();
        }
    }
}

/*
 * Main class
 */
public class ResumeScreeningDemo {
    public static void main(String[] args) {

        List<JobRole> applicants = new ArrayList<>();
        applicants.add(new SoftwareEngineer());
        applicants.add(new DataScientist());
        applicants.add(new ProductManager());

        ResumeScreeningPipeline.screenAll(applicants);
    }
}


