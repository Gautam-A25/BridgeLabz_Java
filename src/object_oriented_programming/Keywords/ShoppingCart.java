package object_oriented_programming.Keywords;

class Product{
    private static double discount = 0.0;

    private String productName;
    private double price;
    private int quantity;

    private final int productId;

    Product(String productName, int quantity, double price, int productId){
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
    }

    public static void updateDiscount(double newDiscount){
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productId);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: ₹" + price);
            System.out.println("Quantity: " + quantity);
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price of 1 product after discount: ₹" + discountedPrice);
        } else {
            System.out.println("Invalid Product object");
        }
    }

}

public class ShoppingCart {
    public static void main(String[] args){
        Product p1 = new Product("Book", 12, 99, 887);
        Product p2 = new Product("Pen", 28, 15, 123);
        Product p3 = new Product("Bag", 5, 1989, 432);

        Product.updateDiscount(10.0);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
        System.out.println();
        p3.displayDetails();
    }
}
