package collections;

import java.time.LocalDate;
import java.util.*;

class Policy {
    int policyNumber;
    String holder;
    LocalDate expiry;
    String type;
    double premium;

    Policy(int p, String h, LocalDate e, String t, double pr) {
        policyNumber = p;
        holder = h;
        expiry = e;
        type = t;
        premium = pr;
    }

    public int hashCode() {
        return policyNumber;
    }

    public boolean equals(Object o) {
        return o instanceof Policy &&
                policyNumber == ((Policy) o).policyNumber;
    }
}

public class InsurancePolicySetSystem {
    public static void main(String[] args) {

        Set<Policy> policies = new HashSet<>();

        policies.add(new Policy(101, "Alice",
                LocalDate.now().plusDays(10), "Health", 5000));
        policies.add(new Policy(102, "Bob",
                LocalDate.now().plusDays(40), "Auto", 3000));
        policies.add(new Policy(101, "Alice",
                LocalDate.now().plusDays(10), "Health", 5000)); // duplicate

        System.out.println("Total Unique Policies: " + policies.size());

        System.out.println("Policies expiring in 30 days:");
        for (Policy p : policies)
            if (p.expiry.isBefore(LocalDate.now().plusDays(30)))
                System.out.println(p.policyNumber);
    }
}

