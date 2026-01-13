package ClassVariables;

import java.util.Scanner;

class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Default Institute";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration);
        System.out.println("Fee: " + fee);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }
}

public class OnlineCourseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String institute = sc.nextLine();
        Course.updateInstituteName(institute);

        String course1 = sc.nextLine();
        int duration1 = sc.nextInt();
        double fee1 = sc.nextDouble();
        sc.nextLine();

        String course2 = sc.nextLine();
        int duration2 = sc.nextInt();
        double fee2 = sc.nextDouble();

        Course c1 = new Course(course1, duration1, fee1);
        Course c2 = new Course(course2, duration2, fee2);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        sc.close();
    }
}

