package collections;

import java.util.*;

public class CheckSetEquality {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));

        System.out.println(set1.equals(set2));
    }
}

