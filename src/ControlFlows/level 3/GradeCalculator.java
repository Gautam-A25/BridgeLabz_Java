import java.util.Scanner;


class GradeCalculator {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int physics = input.nextInt();
        int chemistry = input.nextInt();
        int maths = input.nextInt();


        double average = (physics + chemistry + maths) / 3.0;


        if (average >= 90) {
            System.out.println("Grade A");
        } else if (average >= 75) {
            System.out.println("Grade B");
        } else if (average >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Fail");
        }


        input.close();
    }
}
