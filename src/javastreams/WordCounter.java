package javacollectionstreams.iostreams;
import java.io.*;
import java.util.*;

/*
 Program: Count words and show top 5 frequent
*/

public class WordCounter {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(file));
        HashMap<String, Integer> map = new HashMap<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.toLowerCase().split("\\W+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }

        br.close();

        // Sorting
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 5 words:");
        for (int i = 0; i < 5 && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
}
