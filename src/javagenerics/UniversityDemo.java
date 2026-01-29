package javagenerics;
import java.util.ArrayList;
import java.util.List;

/*
 ============================================================
  UNIVERSITY COURSE MANAGEMENT SYSTEM
 ============================================================
*/

// Abstract course type
abstract class CourseType {
    public abstract void evaluate();
}

// Course implementations
class ExamCourse extends CourseType {
    public void evaluate() {
        System.out.println("Evaluation through exams");
    }
}

class AssignmentCourse extends CourseType {
    public void evaluate() {
        System.out.println("Evaluation through assignments");
    }
}

class ResearchCourse extends CourseType {
    public void evaluate() {
        System.out.println("Evaluation through research work");
    }
}

/*
 * Generic Course class with bounded type
 */
class Course<T extends CourseType> {

    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }
}

/*
 * Utility using wildcards
 */
class CourseUtil {

    public static void processCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            c.evaluate();
        }
    }
}

/*
 * Main class
 */
public class UniversityDemo {
    public static void main(String[] args) {

        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse());

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse());

        CourseUtil.processCourses(examCourses.getCourses());
        CourseUtil.processCourses(researchCourses.getCourses());
    }
}
