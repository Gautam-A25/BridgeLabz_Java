package iostreams.csvdatahandling;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class CSVToJson {

    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));

        br.readLine(); // skip header

        String line;
        List<Student> list = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            list.add(new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2])
            ));
        }

        br.close();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter writer = new FileWriter("output.json");
        gson.toJson(list, writer);
        writer.close();

        System.out.println("CSV converted to JSON successfully!");
    }
}

