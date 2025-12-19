import java.util.Scanner;

public class AthleteRoundsWithMethod {

    // Method to calculate number of rounds
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3; // meters
        double totalDistance = 5000;               // 5 km in meters
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        System.out.println(
                "The total number of rounds the athlete will run is " +
                        rounds + " to complete 5 km"
        );

        input.close();
    }
}
