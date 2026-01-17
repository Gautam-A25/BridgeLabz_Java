import java.util.Scanner;


class StudentGrades2D {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int students = input.nextInt();


        int[][] marks = new int[students][3];
        double[] percentage = new double[students];
        char[] grade = new char[students];


        for (int i = 0; i < students; i++) {


            marks[i][0] = input.nextInt();
            marks[i][1] = input.nextInt();
            marks[i][2] = input.nextInt();


            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                i--;
            }
        }


        for (int i = 0; i < students; i++) {


            percentage[i] =
                (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;


            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else grade[i] = 'F';
        }


        for (int i = 0; i < students; i++) {
            System.out.println(
                marks[i][0] + " " +
                marks[i][1] + " " +
                marks[i][2] + " " +
                percentage[i] + " " +
                grade[i]
            );
        }


        input.close();
    }
}
