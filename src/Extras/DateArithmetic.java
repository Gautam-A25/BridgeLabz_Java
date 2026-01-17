import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

    public static LocalDate calculateNewDate(LocalDate date) {
        LocalDate updatedDate = date.plusDays(7);
        updatedDate = updatedDate.plusMonths(1);
        updatedDate = updatedDate.plusYears(2);
        updatedDate = updatedDate.minusWeeks(3);
        return updatedDate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date in YYYY-MM-DD format:");
        LocalDate inputDate = LocalDate.parse(scanner.next());
        LocalDate resultDate = calculateNewDate(inputDate);

        System.out.println(resultDate);
        scanner.close();
    }
}
