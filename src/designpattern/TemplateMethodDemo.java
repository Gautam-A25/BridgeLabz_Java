package designpattern;

abstract class OrderProcessTemplate {

    // Template Method
    public final void processOrder() {
        selectItem();
        makePayment();
        deliver();
    }

    abstract void selectItem();
    abstract void makePayment();

    void deliver() {
        System.out.println("Order Delivered");
    }
}

class OnlineOrder extends OrderProcessTemplate {

    void selectItem() {
        System.out.println("Item selected from Website");
    }

    void makePayment() {
        System.out.println("Payment done Online");
    }
}

class StoreOrder extends OrderProcessTemplate {

    void selectItem() {
        System.out.println("Item selected from Store");
    }

    void makePayment() {
        System.out.println("Payment done at Counter");
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {

        OrderProcessTemplate online = new OnlineOrder();
        online.processOrder();

        System.out.println();

        OrderProcessTemplate store = new StoreOrder();
        store.processOrder();
    }
}
