package collections;

import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {

        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Laptop", 50000);
        cart.put("Mouse", 500);
        cart.put("Keyboard", 1500);

        Map<Integer, String> sortedByPrice = new TreeMap<>();
        cart.forEach((k,v) -> sortedByPrice.put(v, k));

        System.out.println("Items sorted by price:");
        sortedByPrice.forEach((k,v) ->
                System.out.println(v + " : " + k));
    }
}

