import java.util.Scanner;

public class CustomTrim {

    public static int[] trimIndexes(String text) {
        int start = 0, end = text.length() - 1;

        while (text.charAt(start) == ' ') start++;
        while (text.charAt(end) == ' ') end--;

        return new int[]{start, end + 1};
    }

    public static String substringCustom(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) result += text.charAt(i);
        return result;
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] idx = trimIndexes(text);
        String custom = substringCustom(text, idx[0], idx[1]);
        String builtIn = text.trim();

        System.out.println(compare(custom, builtIn));
    }
}
