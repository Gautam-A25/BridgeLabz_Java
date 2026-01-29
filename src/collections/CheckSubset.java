package collections;

import java.util.*;

public class CheckSubset {
    public static void main(String[] args) {

        Set<Integer> set1 = Set.of(2, 3);
        Set<Integer> set2 = Set.of(1, 2, 3, 4);

        System.out.println(set2.containsAll(set1));
    }
}

