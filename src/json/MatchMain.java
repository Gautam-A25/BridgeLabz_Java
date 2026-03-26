package json;

public class MatchMain {
    public static void main(String[] args) throws Exception {
        JsonProcessor.processJson();
        CsvProcessor.processCsv();

        System.out.println("Censorship completed.");
    }
}
