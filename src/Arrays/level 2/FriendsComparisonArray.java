import java.util.Scanner;


class FriendsComparisonArray {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];


        for (int i = 0; i < 3; i++) {
            ages[i] = input.nextInt();
            heights[i] = input.nextDouble();
        }


        int youngestIndex = 0;
        int tallestIndex = 0;


        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }


        System.out.println("Youngest is " + names[youngestIndex]);
        System.out.println("Tallest is " + names[tallestIndex]);


        input.close();
    }
}
