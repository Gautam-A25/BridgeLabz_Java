package javagenerics;

/*
 ============================================================
  DYNAMIC ONLINE MARKETPLACE
  Concepts:
  - Generic Classes
  - Bounded Type Parameters
  - Generic Methods
 ============================================================
*/

// Category marker interfaces
interface BookCategory {}
interface ClothingCategory {}
interface GadgetCategory {}

/*
 * Generic Product class
 * T is restricted to category types only
 */
class Product<T> {

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println(name + " | Price: " + price);
    }
}

/*
 * Utility class containing a generic method
 */
class DiscountUtil {

    /*
     * Generic method with bounded type
     * Accepts ANY Product type safely
     */
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);
    }
}

/*
 * Main class
 */
public class MarketplaceDemo {
    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Book", 500, new BookCategory() {});

        DiscountUtil.applyDiscount(book, 10);
        book.display();
    }
}

