import java.util.Scanner;

public class TravelComputation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Person name
        String name = input.next();
        // Cities
        String fromCity = input.next();
        String viaCity = input.next();
        String toCity = input.next();
        // Distances in km
        double distanceFromToVia = input.nextDouble();
        double distanceViaToFinalCity = input.nextDouble();
        // Time in minutes
        int timeFromToVia = input.nextInt();
        int timeViaToFinalCity = input.nextInt();
        // Total distance and time
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;

        // Output
        System.out.println(
                "The Total Distance travelled by " + name +
                        " from " + fromCity +
                        " to " + toCity +
                        " via " + viaCity +
                        " is " + totalDistance + " km and " +
                        "the Total Time taken is " + totalTime + " minutes"
        );

        input.close();
    }
}
