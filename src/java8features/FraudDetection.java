package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class FraudDetection {

    static class Transaction {
        String transactionId;
        String policyNumber;
        double amount;
        String transactionDate;
        boolean isFraudulent;

        Transaction(String transactionId, String policyNumber, double amount,
                    String transactionDate, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent = isFraudulent;
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P101", 15000, "2024-01-10", true),
                new Transaction("T2", "P101", 12000, "2024-01-15", true),
                new Transaction("T3", "P101", 20000, "2024-02-01", true),
                new Transaction("T4", "P101", 8000, "2024-02-10", true),
                new Transaction("T5", "P101", 17000, "2024-03-05", true),
                new Transaction("T6", "P102", 30000, "2024-01-20", true),
                new Transaction("T7", "P102", 4000, "2024-02-12", false)
        );

        // 1. Filter fraudulent transactions > 10000
        List<Transaction> frauds =
                transactions.stream()
                        .filter(t -> t.isFraudulent && t.amount > 10000)
                        .collect(Collectors.toList());

        // 2. Group by policy
        Map<String, List<Transaction>> fraudsByPolicy =
                frauds.stream()
                        .collect(Collectors.groupingBy(t -> t.policyNumber));

        // 3. Aggregate fraud count & total amount
        System.out.println("Fraud Summary:");
        fraudsByPolicy.forEach((policy, txns) -> {
            long count = txns.size();
            double totalAmount = txns.stream().mapToDouble(t -> t.amount).sum();

            System.out.println(policy + " -> Count: " + count +
                    ", Total Fraud Amount: " + totalAmount);

            // 4. Alert generation
            if (count > 5 || totalAmount > 50000) {
                System.out.println("🚨 ALERT: High fraud detected for policy " + policy);
            }
        });
    }
}
