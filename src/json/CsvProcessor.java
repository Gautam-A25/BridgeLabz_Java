package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CsvProcessor {
    public static void processCsv() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("matches.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("censored_matches.csv"));

        String line;

        writer.write(reader.readLine());
        writer.newLine();

        while((line = reader.readLine()) != null){

            String[] parts = line.split(",");

            parts[1] = CensorService.maskTeam(parts[1]);
            parts[2] = CensorService.maskTeam(parts[2]);
            parts[3] = "REDACTED";

            writer.write(String.join(",", parts));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
