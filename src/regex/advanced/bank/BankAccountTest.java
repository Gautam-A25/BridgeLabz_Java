package regex.advanced.bank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    // Creating BankAccount object
    BankAccount account = new BankAccount();

    // Test deposit functionality
    @Test
    void testDeposit() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    // Test withdraw functionality
    @Test
    void testWithdraw() {
        account.deposit(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    // Test exception for insufficient balance
    @Test
    void testInsufficientBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100);
        });
    }
}
