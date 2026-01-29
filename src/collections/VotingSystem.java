package collections;

import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {

        Map<String, Integer> votes = new HashMap<>();
        votes.put("Alice", 120);
        votes.put("Bob", 150);
        votes.put("Carol", 100);

        Map<String, Integer> sorted =
                new TreeMap<>(votes);

        System.out.println("Election Results:");
        sorted.forEach((k,v) ->
                System.out.println(k + " -> " + v));
    }
}

