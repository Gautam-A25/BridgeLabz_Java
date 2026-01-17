import java.util.Scanner;


class StudentGrades {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int students = input.nextInt();


        int[] physics = new int[students];
        int[] chemistry = new int[students];
        int[] maths = new int[students];
        double[] percentage = new double[students];
        char[] grade = new char[students];


        for (int i = 0; i < students; i++) {


            physics[i] = input.nextInt();
            chemistry[i] = input.nextInt();
            maths[i] = input.nextInt();


            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                i--;
            }
        }


        for (int i = 0; i < students; i++) {


            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;


            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else grade[i] = 'F';
        }


        for (int i = 0; i < students; i++) {
            System.out.println(
                physics[i] + " " +
                chemistry[i] + " " +
                maths[i] + " " +
                percentage[i] + " " +
                grade[i]
            );
        }


        input.close();
    }
}
