import java.util.Scanner;

class FriendStats {

    public static int youngestIndex(int[] ages) {
        int idx = 0;
        for (int i = 1; i < ages.length; i++)
            if (ages[i] < ages[idx]) idx = i;
        return idx;
    }

    public static int tallestIndex(double[] heights) {
        int idx = 0;
        for (int i = 1; i < heights.length; i++)
            if (heights[i] > heights[idx]) idx = i;
        return idx;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            ages[i] = input.nextInt();
            heights[i] = input.nextDouble();
        }

        System.out.println(names[youngestIndex(ages)]);
        System.out.println(names[tallestIndex(heights)]);

        input.close();
    }
}
