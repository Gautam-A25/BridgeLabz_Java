package javagenerics;
import java.util.ArrayList;
import java.util.List;

/*  SMART WAREHOUSE MANAGEMENT SYSTEM
  Concepts Used:
  1. Abstraction
  2. Generic Classes
  3. Bounded Type Parameters
  4. Wildcards

 * Abstract class WarehouseItem
 * -----------------------------
 * This is the base class for all items stored in the warehouse.
 * All item types MUST extend this class.
 */
abstract class WarehouseItem {

    private String name;

    // Constructor
    public WarehouseItem(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Abstract method to enforce implementation
    public abstract void displayInfo();
}

/*
 * Electronics class
 */
class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics Item: " + getName());
    }
}

/*
 * Groceries class
 */
class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Grocery Item: " + getName());
    }
}

/*
 * Furniture class
 */
class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Furniture Item: " + getName());
    }
}

/*
 * Generic Storage Class
 * ---------------------
 * T is a bounded type parameter.
 * It ensures that ONLY WarehouseItem objects
 * (or its subclasses) can be stored.
 */
class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    // Add item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Return all stored items
    public List<T> getItems() {
        return items;
    }
}

/*
 * Utility class using Wildcards
 * -----------------------------
 * The wildcard (? extends WarehouseItem) allows
 * reading items of ANY subclass of WarehouseItem
 * safely without knowing the exact type.
 */
class WarehouseUtil {

    public static void displayAllItems(List<? extends WarehouseItem> items) {

        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}

/*
 * Main Class
 * Demonstrates storing and displaying different
 * warehouse items using generics and wildcards.
 */
public class WarehouseItems{

    public static void main(String[] args) {

        // Create storage for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Display items using wildcard method
        System.out.println("=== Electronics ===");
        WarehouseUtil.displayAllItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtil.displayAllItems(groceryStorage.getItems());

        System.out.println("\n=== Furniture ===");
        WarehouseUtil.displayAllItems(furnitureStorage.getItems());
    }
}
