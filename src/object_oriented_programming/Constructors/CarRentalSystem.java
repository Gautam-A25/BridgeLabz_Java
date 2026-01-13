package object_oriented_programming.Constructors;
import java.util.Scanner;

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

    CarRental() {
        customerName = "Customer";
        carModel = "Standard";
        rentalDays = 1;
        costPerDay = 1000;
    }

    CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CarRental r1 = new CarRental();
        r1.displayDetails();

        String name = sc.nextLine();
        String model = sc.nextLine();
        int days = sc.nextInt();
        double rate = sc.nextDouble();

        CarRental r2 = new CarRental(name, model, days, rate);
        r2.displayDetails();

        sc.close();
    }
}
