package iostreams.csvdatahandling;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JsonToCSV {

    static class Student {
        int id;
        String name;
        int age;
    }

    public static void main(String[] args) throws Exception {

        Gson gson = new Gson();

        // Read JSON
        Reader reader = new FileReader("students.json");

        Type listType = new TypeToken<List<Student>>() {}.getType();
        List<Student> students = gson.fromJson(reader, listType);

        reader.close();

        // Write CSV
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"));

        bw.write("ID,Name,Age");
        bw.newLine();

        for (Student s : students) {
            bw.write(s.id + "," + s.name + "," + s.age);
            bw.newLine();
        }

        bw.close();

        System.out.println("JSON converted to CSV successfully!");
    }
}

