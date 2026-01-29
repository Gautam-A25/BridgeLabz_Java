package collections;
import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 1, 2, 2, 3, 4);
        Set<Integer> set = new LinkedHashSet<>(list);

        System.out.println(new ArrayList<>(set));
    }
}