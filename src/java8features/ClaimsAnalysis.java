package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class ClaimsAnalysis {

    static class Claim {
        String claimId;
        String policyNumber;
        double claimAmount;
        String claimDate;
        String status;

        Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }
    }

    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P101", 6000, "2024-01-10", "Approved"),
                new Claim("C2", "P101", 9000, "2024-02-12", "Approved"),
                new Claim("C3", "P102", 3000, "2024-03-01", "Rejected"),
                new Claim("C4", "P103", 12000, "2024-02-20", "Approved"),
                new Claim("C5", "P104", 7000, "2024-01-15", "Approved"),
                new Claim("C6", "P103", 8000, "2024-03-18", "Approved")
        );

        // 1. Filter Approved claims with amount > 5000
        List<Claim> filteredClaims =
                claims.stream()
                        .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                        .collect(Collectors.toList());

        // 2. Group by policy number
        Map<String, List<Claim>> claimsByPolicy =
                filteredClaims.stream()
                        .collect(Collectors.groupingBy(c -> c.policyNumber));

        // 3. Aggregate total & average claim amount
        System.out.println("Total & Average Claim Amount per Policy:");
        Map<String, DoubleSummaryStatistics> statsByPolicy =
                filteredClaims.stream()
                        .collect(Collectors.groupingBy(
                                c -> c.policyNumber,
                                Collectors.summarizingDouble(c -> c.claimAmount)
                        ));

        statsByPolicy.forEach((k, v) ->
                System.out.println(k + " -> Total: " + v.getSum() +
                        ", Average: " + v.getAverage()));

        // 4. Top 3 policies with highest total claim amount
        System.out.println("\nTop 3 Policies by Total Claim Amount:");
        statsByPolicy.entrySet().stream()
                .sorted((e1, e2) ->
                        Double.compare(e2.getValue().getSum(), e1.getValue().getSum()))
                .limit(3)
                .forEach(e ->
                        System.out.println(e.getKey() + " -> " + e.getValue().getSum()));
    }
}

