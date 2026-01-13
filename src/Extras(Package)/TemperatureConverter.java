import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double value = sc.nextDouble();
        char type = sc.next().charAt(0);

        if (type == 'C')
            System.out.println(celsiusToFahrenheit(value));
        else
            System.out.println(fahrenheitToCelsius(value));
    }
}
