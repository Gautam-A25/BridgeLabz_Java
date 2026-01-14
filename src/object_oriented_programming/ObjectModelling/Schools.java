package object_oriented_programming.ObjectModelling;
import java.util.*;

class School {
    private String name;
    private List<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student student) {
        students.add(student);
    }
}

class Student {
    private String name;
    private Set<Course> courses = new HashSet<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    void viewCourses() {
        System.out.println(name + " courses:");
        courses.forEach(c -> System.out.println(c.getTitle()));
    }

    String getName() {
        return name;
    }
}

class Course {
    private String title;
    private Set<Student> students = new HashSet<>();

    Course(String title) {
        this.title = title;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void viewStudents() {
        System.out.println("Students in " + title + ":");
        students.forEach(s -> System.out.println(s.getName()));
    }

    String getTitle() {
        return title;
    }
}


class Schools{
    public static void main(String[] args) {
        School school = new School("Pon Vidyashram");

        Student a = new Student("Dinesh");
        Student b = new Student("Ritika");

        Course math = new Course("Math");
        Course science = new Course("Science");

        school.addStudent(a);
        school.addStudent(b);

        a.enroll(math);
        a.enroll(science);
        b.enroll(science);

        a.viewCourses();
        science.viewStudents();
    }
}
