package collections;

import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String text = "Hello world, hello Java!";
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        System.out.println(map);
    }
}

