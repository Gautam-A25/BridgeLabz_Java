package ClassVariables;


import java.util.Scanner;

class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000.0;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double newFee = sc.nextDouble();
        sc.nextLine();
        Vehicle.updateRegistrationFee(newFee);

        String owner1 = sc.nextLine();
        String type1 = sc.nextLine();

        String owner2 = sc.nextLine();
        String type2 = sc.nextLine();

        Vehicle v1 = new Vehicle(owner1, type1);
        Vehicle v2 = new Vehicle(owner2, type2);

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        sc.close();
    }
}
