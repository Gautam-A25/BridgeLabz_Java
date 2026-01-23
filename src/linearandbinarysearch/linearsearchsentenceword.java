/*
 This program uses Linear Search to find the first sentence
 that contains a specific word in a list of sentences.
*/

public class linearsearchsentenceword {

    // Method to find the first sentence containing the word
    static String findSentenceWithWord(String[] sentences, String word) {

        // Traverse each sentence
        for (String sentence : sentences) {

            // Check if the sentence contains the given word
            if (sentence.contains(word)) {
                return sentence;
            }
        }

        // Word not found in any sentence
        return "Not Found";
    }

    public static void main(String[] args) {

        String[] sentences = {
                "Java is a powerful language",
                "Data structures are important",
                "Linear search is simple",
                "Algorithms improve efficiency"
        };

        String wordToSearch = "search";

        String result = findSentenceWithWord(sentences, wordToSearch);

        System.out.println("Result: " + result);
    }
}
