import java.util.Scanner;

class LeapYearChecker {

    public static boolean isLeapYear(int year) {
        return year >= 1582 &&
               (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int year = input.nextInt();

        System.out.println(isLeapYear(year));

        input.close();
    }
}
