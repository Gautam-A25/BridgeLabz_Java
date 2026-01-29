package collections;

import java.time.LocalDate;
import java.util.*;

class PolicyDetails {
    String holder;
    LocalDate expiry;
    String type;

    PolicyDetails(String h, LocalDate e, String t) {
        holder = h;
        expiry = e;
        type = t;
    }
}

public class InsurancePolicyMapSystem {
    public static void main(String[] args) {

        Map<Integer, PolicyDetails> policies = new HashMap<>();

        policies.put(101,
                new PolicyDetails("Alice", LocalDate.now().plusDays(20), "Health"));
        policies.put(102,
                new PolicyDetails("Bob", LocalDate.now().minusDays(2), "Auto"));

        System.out.println("Expired Policies:");
        policies.entrySet().removeIf(
                e -> e.getValue().expiry.isBefore(LocalDate.now())
        );

        System.out.println(policies.keySet());
    }
}
