import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    void addItem(int qty) {
        if (qty > 0) {
            quantity += qty;
        }
    }

    void removeItem(int qty) {
        if (qty > 0 && qty <= quantity) {
            quantity -= qty;
        }
    }

    double totalCost() {
        return price * quantity;
    }

    void displayTotal() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost());
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String itemName = sc.nextLine();
        double price = sc.nextDouble();
        int addQty = sc.nextInt();
        int removeQty = sc.nextInt();

        CartItem item = new CartItem(itemName, price);

        item.addItem(addQty);
        item.removeItem(removeQty);
        item.displayTotal();

        sc.close();
    }
}

