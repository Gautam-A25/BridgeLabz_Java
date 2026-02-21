package designpattern;

interface ATMState {
    void handleRequest(ATMContext context);
}

class NoCardState implements ATMState {
    public void handleRequest(ATMContext context) {
        System.out.println("Insert Card");
        context.setState(new HasCardState());
    }
}

class HasCardState implements ATMState {
    public void handleRequest(ATMContext context) {
        System.out.println("Enter PIN");
        context.setState(new AuthorizedState());
    }
}

class AuthorizedState implements ATMState {
    public void handleRequest(ATMContext context) {
        System.out.println("Transaction Allowed");
    }
}

class ATMContext {

    private ATMState state;

    public ATMContext() {
        state = new NoCardState();
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest(this);
    }
}

public class StateDemo {
    public static void main(String[] args) {

        ATMContext atm = new ATMContext();

        atm.request();
        atm.request();
        atm.request();
    }
}
