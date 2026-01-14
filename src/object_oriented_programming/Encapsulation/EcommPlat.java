package object_oriented_programming.Encapsulation;

import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.1;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "18% GST";
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.2;
    }
}

public class EcommPlat {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics(1, "Laptop", 60000));
        products.add(new Clothing(2, "Jacket", 3000));

        for (Product p : products) {
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - p.calculateDiscount();
            System.out.println(finalPrice);
        }
    }
}

