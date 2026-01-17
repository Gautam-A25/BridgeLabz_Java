import java.util.Scanner;

public class CharacterClassifier {

    public static String classify(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) >= 0) return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] classifyText(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = classify(text.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[][] result = classifyText(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + result[i][1]);
        }
    }
}
