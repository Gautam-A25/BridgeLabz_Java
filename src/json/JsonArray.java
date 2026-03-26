package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class User {
    public String name;
    public int age;
}

public class JsonArray {
    public static void main(String[] args) throws Exception {
        List<User> users = new ArrayList<>();

        User u1 = new User();
        u1.name = "Akhil";
        u1.age = 22;

        User u2 = new User();
        u2.name = "Rahul";
        u2.age = 30;

        users.add(u1);
        users.add(u2);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(users);

        System.out.println(json);
    }
}
