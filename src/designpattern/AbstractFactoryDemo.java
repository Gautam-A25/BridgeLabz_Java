package designpattern;

interface Car {
    void drive();
}

interface Bike {
    void ride();
}

class Sedan implements Car {
    public void drive() {
        System.out.println("Driving Sedan");
    }
}

class SportsBike implements Bike {
    public void ride() {
        System.out.println("Riding Sports Bike");
    }
}

interface VehicleFactory {
    Car createCar();
    Bike createBike();
}

class CarFactory implements VehicleFactory {
    public Car createCar() {
        return new Sedan();
    }
    public Bike createBike() {
        return null;
    }
}

class BikeFactory implements VehicleFactory {
    public Car createCar() {
        return null;
    }
    public Bike createBike() {
        return new SportsBike();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        VehicleFactory carFactory = new CarFactory();
        Car car = carFactory.createCar();
        car.drive();

        VehicleFactory bikeFactory = new BikeFactory();
        Bike bike = bikeFactory.createBike();
        bike.ride();
    }
}
