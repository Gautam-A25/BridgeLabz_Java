package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class ProductSalesAnalysis {

    static class Sale {
        String productId;
        int quantity;
        double price;

        Sale(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static class ProductSales {
        String productId;
        double totalRevenue;

        ProductSales(String productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }

        double getTotalRevenue() {
            return totalRevenue;
        }

        @Override
        public String toString() {
            return productId + " -> Revenue: $" + totalRevenue;
        }
    }

    public static void main(String[] args) {

        List<Sale> sales = Arrays.asList(
                new Sale("P1", 15, 100),
                new Sale("P2", 8, 200),
                new Sale("P3", 20, 50),
                new Sale("P4", 30, 40),
                new Sale("P5", 12, 300),
                new Sale("P6", 25, 80)
        );

        List<ProductSales> topProducts =
                sales.stream()
                        .filter(s -> s.quantity > 10)
                        .map(s -> new ProductSales(
                                s.productId,
                                s.quantity * s.price))
                        .sorted(Comparator.comparing(ProductSales::getTotalRevenue).reversed())
                        .limit(5)
                        .collect(Collectors.toList());

        System.out.println("Top 5 Products by Revenue:");
        topProducts.forEach(System.out::println);
    }
}

