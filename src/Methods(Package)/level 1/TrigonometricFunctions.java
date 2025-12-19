import java.util.Scanner;

public class TrigonometricFunctions {

    // Method to calculate sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);

        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double angle = input.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);

        System.out.println("Sine of " + angle + " degrees is " + result[0]);
        System.out.println("Cosine of " + angle + " degrees is " + result[1]);
        System.out.println("Tangent of " + angle + " degrees is " + result[2]);

        input.close();
    }
}
