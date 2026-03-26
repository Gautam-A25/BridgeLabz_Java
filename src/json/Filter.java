package json;

import com.fasterxml.jackson.databind.*;
import java.io.File;

public class Filter {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode array = mapper.readTree(new File("users.json"));

        for(JsonNode user : array) {

            if(user.get("age").asInt() > 25) {
                System.out.println(user.get("name").asText());
            }
        }
    }
}
