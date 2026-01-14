package object_oriented_programming.ObjectModelling;
import java.util.ArrayList;

class Accounts {
    private long accNo;
    private Bank bank;
    private double balance;

    Accounts(long accNo,double balance, Bank bank) {
        this.accNo = accNo;
        this.balance = balance;
        this.bank = bank;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public long getAccountNumber() {
        return accNo;
    }

    public void withdrawMoney(int withdraw) {
        if (withdraw < balance) {
            balance -= withdraw;
            System.out.println("Withdrawal of " + withdraw + " is successful!!");
        } else {
            System.out.println("Insufficient Balance!!");
        }
    }
}

class Bank {
    private String name;
    private ArrayList<Customer> customers;
    private int accountCounter = 1000;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Accounts openAccount(Customer customer, double initialDeposit) {
        Accounts newAccount = new Accounts(accountCounter++, initialDeposit, this);
        customer.addAccount(newAccount);
        System.out.println("Account " + newAccount.getAccountNumber() +
                " opened for " + customer.getCustomerName() +
                " at " + name + " with balance " + initialDeposit);
        return newAccount;
    }
}
class Customer{
    private String accHolder;
    private ArrayList<Accounts> account;

    Customer(String accHolder){
        this.accHolder = accHolder;
        this.account = new ArrayList<>();
    }

    public void addAccount(Accounts acc){
        account.add(acc);
    }

    public String getCustomerName(){
        return accHolder;
    }

    public void displayCustomer(){
        System.out.println("Customer name: " + accHolder);
        for(Accounts a : account){
            System.out.println("Account " + a.getAccountNumber() +
                    " at " + a.getBank().getName() +
                    " has balance: " + a.getBalance());
        }
        System.out.println();
    }
}

public class BankAccounts {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank of India");
        Customer c1 = new Customer("Aayush");

        bank.addCustomer(c1);
        bank.openAccount(c1, 10000);
        bank.openAccount(c1, 5000);
        System.out.println();
        c1.displayCustomer();
    }
}
