package collections;



import java.util.*;

public class RotateList {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        int k = 2;

        k = k % list.size();
        List<Integer> temp = new ArrayList<>(list.subList(0, k));
        list.removeAll(temp);
        list.addAll(temp);

        System.out.println(list);
    }
}