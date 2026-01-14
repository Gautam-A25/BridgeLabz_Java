package object_oriented_programming.Encapsulation;

interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    BankAccount(String acc, String name, double bal) {
        accountNumber = acc;
        holderName = name;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String a, String n, double b) {
        super(a, n, b);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

public class BankSys {
    public static void main(String[] args) {
        BankAccount acc = new SavingsAccount("101", "Aayush", 10000);
        System.out.println(acc.calculateInterest());
    }
}

