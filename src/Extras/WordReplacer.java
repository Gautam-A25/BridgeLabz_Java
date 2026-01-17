import java.util.Scanner;

public class WordReplacer {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        int index = 0;

        while (index < sentence.length()) {
            if (index + oldWord.length() <= sentence.length()
                    && sentence.substring(index, index + oldWord.length()).equals(oldWord)) {
                result = result + newWord;
                index = index + oldWord.length();
            } else {
                result = result + sentence.charAt(index);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        System.out.println("Enter the word to be replaced:");
        String oldWord = scanner.next();
        System.out.println("Enter the new word:");
        String newWord = scanner.next();
        scanner.close();

        System.out.println(replaceWord(sentence, oldWord, newWord));
    }
}
