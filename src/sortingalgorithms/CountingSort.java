package sortingalgorithms;

public class CountingSort {
    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;

        int[] count = new int[maxAge - minAge + 1];

        for (int age : ages) {
            count[age - minAge]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                ages[index++] = i + minAge;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 12};
        countingSort(ages);

        for (int a : ages) {
            System.out.print(a + " ");
        }
    }
}

