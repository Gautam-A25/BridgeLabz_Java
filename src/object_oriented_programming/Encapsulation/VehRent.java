package object_oriented_programming.Encapsulation;

import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private double rentalRate;

    Vehicle(String vehicleNumber, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.rentalRate = rentalRate;
    }

    public double getRentalRate() { return rentalRate; }
    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    Car(String no, double rate) {
        super(no, rate);
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Car Insurance";
    }
}

public class VehRent {
    public static void main(String[] args) {
        List<Vehicle> vehicles = List.of(new Car("KA01", 2000));
        for (Vehicle v : vehicles) {
            System.out.println(v.calculateRentalCost(3));
        }
    }
}

