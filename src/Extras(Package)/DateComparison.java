import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    public static void compareDates(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate)) {
            System.out.println("First date is before second date");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("First date is after second date");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are the same");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first date (YYYY-MM-DD):");
        LocalDate firstDate = LocalDate.parse(scanner.next());
        System.out.println("Enter second date (YYYY-MM-DD):");
        LocalDate secondDate = LocalDate.parse(scanner.next());

        compareDates(firstDate, secondDate);
        scanner.close();
    }
}
