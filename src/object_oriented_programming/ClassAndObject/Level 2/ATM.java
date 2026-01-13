import java.util.Scanner;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int accNo = sc.nextInt();
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        account.displayBalance();

        sc.close();
    }
}
