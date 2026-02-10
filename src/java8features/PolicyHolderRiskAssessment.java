package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class PolicyHolderRiskAssessment {

    static class PolicyHolder {
        String holderId;
        String name;
        int age;
        String policyType;
        double premiumAmount;

        PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }
    }

    static class RiskAssessment {
        String holderId;
        String name;
        double riskScore;

        RiskAssessment(String holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }

        double getRiskScore() {
            return riskScore;
        }

        @Override
        public String toString() {
            return name + " (Risk Score: " + riskScore + ")";
        }
    }

    public static void main(String[] args) {

        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H1", "Alice", 65, "Life", 40000),
                new PolicyHolder("H2", "Bob", 55, "Health", 30000),
                new PolicyHolder("H3", "Charlie", 70, "Life", 50000),
                new PolicyHolder("H4", "David", 62, "Life", 25000),
                new PolicyHolder("H5", "Eve", 45, "Life", 20000)
        );

        // 1. Filter Life policy holders above 60
        List<RiskAssessment> riskAssessments =
                holders.stream()
                        .filter(h -> h.policyType.equals("Life") && h.age > 60)
                        .map(h -> new RiskAssessment(
                                h.holderId,
                                h.name,
                                h.premiumAmount / h.age))
                        .sorted(Comparator.comparing(RiskAssessment::getRiskScore).reversed())
                        .collect(Collectors.toList());

        System.out.println("Risk Assessments:");
        riskAssessments.forEach(System.out::println);

        // 2. Categorize risk
        System.out.println("\nRisk Categories:");
        Map<String, List<RiskAssessment>> categorizedRisk =
                riskAssessments.stream()
                        .collect(Collectors.groupingBy(r ->
                                r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        categorizedRisk.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(System.out::println);
        });
    }
}
