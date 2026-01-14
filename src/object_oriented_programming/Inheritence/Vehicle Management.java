package object_oriented_programming.Inheritence;

interface Refuelable {
    void refuel();
}

class VehicleBase {
    int maxSpeed;
    String model;

    VehicleBase(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends VehicleBase {
    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println("Charging vehicle");
    }
}

class PetrolVehicle extends VehicleBase implements Refuelable {
    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println("Refueling vehicle");
    }
}

