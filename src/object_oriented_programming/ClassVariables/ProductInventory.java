package object_oriented_programming.ClassVariables;

import java.util.Scanner;

class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}

public class ProductInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name1 = sc.nextLine();
        double price1 = sc.nextDouble();
        sc.nextLine();

        String name2 = sc.nextLine();
        double price2 = sc.nextDouble();

        Product p1 = new Product(name1, price1);
        Product p2 = new Product(name2, price2);

        p1.displayProductDetails();
        p2.displayProductDetails();

        Product.displayTotalProducts();

        sc.close();
    }
}

