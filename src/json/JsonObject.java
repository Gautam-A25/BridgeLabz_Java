package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class JsonObject {
    public static void main(String[] args) throws Exception {

        Map<String, Object> student = new HashMap<>();
        student.put("name", "Akhil");
        student.put("age", 22);
        student.put("subjects", Arrays.asList("Math", "Java", "DBMS"));

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(student);

        System.out.println(json);
    }
}
