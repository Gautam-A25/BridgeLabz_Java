package object_oriented_programming.Encapsulation;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    protected double ratePerKm;

    Vehicle(String id, double rate) {
        vehicleId = id;
        ratePerKm = rate;
    }

    abstract double calculateFare(double distance);

    void getVehicleDetails() {
        System.out.println(vehicleId);
    }
}

class Auto extends Vehicle {
    Auto(String id, double rate) {
        super(id, rate);
    }

    double calculateFare(double distance) {
        return ratePerKm * distance;
    }
}

public class RideHail {
    public static void main(String[] args) {
        Vehicle v = new Auto("AUTO1", 15);
        System.out.println(v.calculateFare(10));
    }
}

