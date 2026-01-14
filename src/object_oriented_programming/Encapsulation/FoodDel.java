package object_oriented_programming.Encapsulation;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    protected double price;
    protected int quantity;

    FoodItem(String name, double price, int qty) {
        itemName = name;
        this.price = price;
        quantity = qty;
    }

    abstract double calculateTotalPrice();

    void getItemDetails() {
        System.out.println(itemName);
    }
}

class NonVegItem extends FoodItem implements Discountable {
    NonVegItem(String n, double p, int q) {
        super(n, p, q);
    }

    double calculateTotalPrice() {
        return price * quantity + 50;
    }

    public double applyDiscount() {
        return 100;
    }

    public String getDiscountDetails() {
        return "Flat 100 off";
    }
}

public class FoodDel {
    public static void main(String[] args) {
        FoodItem item = new NonVegItem("Chicken", 200, 2);
        System.out.println(item.calculateTotalPrice());
    }
}

