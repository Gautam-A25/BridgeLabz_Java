package regex.advanced.bank;

public class BankAccount {

    private double balance = 0;

    // Adds money to the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraws money if balance is sufficient
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    // Returns current balance
    public double getBalance() {
        return balance;
    }
}
