package object_oriented_programming.ObjectModelling;

class ECustomer {
    private String name;

    ECustomer(String name) {
        this.name = name;
    }

    Order placeOrder() {
        return new Order(this);
    }

    String getName() {
        return name;
    }
}

class Order {
    private ECustomer customer;
    private java.util.List<Product> products = new java.util.ArrayList<>();

    Order(ECustomer customer) {
        this.customer = customer;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void showOrder() {
        System.out.println("Order by " + customer.getName());
        products.forEach(p -> System.out.println(p.getName()));
    }
}

class Product {
    private String name;

    Product(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
class Ecommerce {
    public static void main(String[] args) {
        ECustomer customer = new ECustomer("Naveen Karthik");

        Order order = customer.placeOrder();
        order.addProduct(new Product("Laptop"));
        order.addProduct(new Product("Mouse"));

        order.showOrder();
    }
}