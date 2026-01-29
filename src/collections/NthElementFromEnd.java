package collections;

import java.util.*;

public class NthElementFromEnd {
    public static void main(String[] args) {

        LinkedList<String> list =
                new LinkedList<>(List.of("A", "B", "C", "D", "E"));
        int n = 2;

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        for (int i = 0; i < n; i++)
            fast.next();

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        System.out.println(slow.next());
    }
}

