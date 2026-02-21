package designpattern;

interface ShoppingItem {
    int accept(ShoppingVisitor visitor);
}

class BookItem implements ShoppingItem {

    private int price;

    public BookItem(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int accept(ShoppingVisitor visitor) {
        return visitor.visit(this);
    }
}

class ElectronicsItem implements ShoppingItem {

    private int price;

    public ElectronicsItem(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int accept(ShoppingVisitor visitor) {
        return visitor.visit(this);
    }
}

interface ShoppingVisitor {
    int visit(BookItem book);
    int visit(ElectronicsItem electronics);
}

class PriceCalculatorVisitor implements ShoppingVisitor {

    public int visit(BookItem book) {
        return book.getPrice();
    }

    public int visit(ElectronicsItem electronics) {
        return electronics.getPrice() + 100; // tax
    }
}

public class VisitorDemo {
    public static void main(String[] args) {

        ShoppingItem book = new BookItem(500);
        ShoppingItem laptop = new ElectronicsItem(50000);

        ShoppingVisitor visitor = new PriceCalculatorVisitor();

        int total = book.accept(visitor) + laptop.accept(visitor);

        System.out.println("Total Price: " + total);
    }
}