package designpattern;

class AccountService {
    public void createAccount() {
        System.out.println("Account Created");
    }
}

class BalanceService {
    public void checkBalance() {
        System.out.println("Balance Checked");
    }
}

class TransactionService {
    public void transfer() {
        System.out.println("Money Transferred");
    }
}

class BankFacade {

    private AccountService account = new AccountService();
    private BalanceService balance = new BalanceService();
    private TransactionService transaction = new TransactionService();

    public void performBankOperation() {
        account.createAccount();
        balance.checkBalance();
        transaction.transfer();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {

        BankFacade bank = new BankFacade();
        bank.performBankOperation();
    }
}