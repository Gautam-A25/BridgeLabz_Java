package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode obj1 = mapper.createObjectNode();
        obj1.put("name", "Akhil");

        ObjectNode obj2 = mapper.createObjectNode();
        obj2.put("age", 22);

        obj1.setAll(obj2);

        System.out.println(obj1.toPrettyString());
    }
}