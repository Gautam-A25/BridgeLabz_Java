import java.util.Scanner;

class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    double totalCost(int quantity) {
        return price * quantity;
    }
}

public class Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int itemCode = sc.nextInt();
        sc.nextLine();
        String itemName = sc.nextLine();
        double price = sc.nextDouble();
        int quantity = sc.nextInt();

        Item item = new Item(itemCode, itemName, price);

        item.displayDetails();
        System.out.println("Total Cost: " + item.totalCost(quantity));

        sc.close();
    }
}
