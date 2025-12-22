import java.util.Scanner;

public class AnagramCheck {

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] freq = new int[256];

        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i)]++;
            freq[b.charAt(i)]--;
        }

        for (int i : freq)
            if (i != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isAnagram(sc.nextLine(), sc.nextLine()));
    }
}
