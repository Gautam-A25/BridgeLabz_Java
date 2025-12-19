import java.util.Scanner;

public class SpringSeason {

    // Method to check if given date is in Spring Season
    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int month = input.nextInt();
        int day = input.nextInt();

        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        input.close();
    }
}
