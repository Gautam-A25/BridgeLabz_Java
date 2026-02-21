package designpattern;

interface PaymentStrategy {
    void pay(int amount);
}

class CashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}

class CardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class UPIPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class PaymentContext {

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(int amount) {
        strategy.pay(amount);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        context.setStrategy(new CashPayment());
        context.makePayment(1000);

        context.setStrategy(new CardPayment());
        context.makePayment(2000);

        context.setStrategy(new UPIPayment());
        context.makePayment(3000);
    }
}