package object_oriented_programming.ObjectModelling;
import java.util.*;

class Univ {
    private String name;
    private List<Dept> departments = new ArrayList<>();

    Univ(String name) {
        this.name = name;
    }

    void addDepartment(String name) {
        departments.add(new Dept(name));
    }

    void displayUniversity() {
        System.out.println("University: " + name);
        if (departments.isEmpty()) {
            System.out.println(" No departments available.");
        } else {
            System.out.println(" Departments:");
            for (Dept d : departments) {
                d.displayDept();
            }
        }
        System.out.println();
    }

    void closeUniversity() {
        departments.clear();
        System.out.println("University deleted with all departments");
    }
}

class Dept {
    private String name;

    Dept(String name) {
        this.name = name;
    }

    void displayDept() {
        System.out.println(" * " + name);
    }
}

class Faculty {
    private String name;

    Faculty(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class University {
    public static void main(String[] args) {
        Univ uni = new Univ("SRM University");

        uni.addDepartment("CSE");
        uni.addDepartment("ECE");

        Faculty faculty = new Faculty("Dr. Jason Rajan");
        System.out.println("Faculty exists independently: " + faculty.getName());
        System.out.println();

        uni.displayUniversity();

        uni.closeUniversity();
    }
}