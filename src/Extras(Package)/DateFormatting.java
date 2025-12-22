import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {

    public static void displayFormattedDates(LocalDate date) {
        DateTimeFormatter formatOne = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatTwo = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatThree = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        System.out.println(date.format(formatOne));
        System.out.println(date.format(formatTwo));
        System.out.println(date.format(formatThree));
    }

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        displayFormattedDates(currentDate);
    }
}
