package object_oriented_programming.Keywords;

class Vehicle{
    public static int registrationFees = 2000;

    private String ownerName, vehicleType;
    private final String registrationNumber;

    Vehicle(String ownerName, String vehicleType, String registrationNumber){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: ₹" + registrationFees);
    }

    public static void updateRegistrationFee(int newReg){
        registrationFees = newReg;
    }
}
public class VehicleRegistration {
    public static void main(String[] args){
        Vehicle v1 = new Vehicle("Aayush", "Car", "HR26D1234");

        Vehicle.updateRegistrationFee(6767);

        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        } else {
            System.out.println("Object is not a Vehicle.");
        }
    }
}
