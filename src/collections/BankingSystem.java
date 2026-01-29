package collections;

import java.util.*;

class Withdrawal {
    int account;
    int amount;

    Withdrawal(int a, int amt) {
        account = a;
        amount = amt;
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        Map<Integer, Integer> accounts = new HashMap<>();
        accounts.put(101, 5000);
        accounts.put(102, 3000);

        Queue<Withdrawal> queue = new LinkedList<>();
        queue.add(new Withdrawal(101, 2000));
        queue.add(new Withdrawal(102, 1000));

        while (!queue.isEmpty()) {
            Withdrawal w = queue.remove();
            accounts.put(w.account,
                    accounts.get(w.account) - w.amount);
        }

        System.out.println(accounts);
    }
}

