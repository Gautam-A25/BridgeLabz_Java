import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        double perimeter = side1 + side2 + side3;   // in meters
        double totalDistance = 5000;                 // 5 km in meters

        double rounds = totalDistance / perimeter;

        System.out.println(
                "The total number of rounds the athlete will run is " +
                        rounds + " to complete 5 km"
        );

        input.close();
    }
}
