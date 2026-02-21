package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

// Renamed class to avoid duplicate
class JsonUser {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public JsonUser(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

// Serializer
class JsonSerializer {

    public static String convertToJson(Object obj) throws IllegalAccessException {

        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);

                JsonField annotation = field.getAnnotation(JsonField.class);

                json.append("\"")
                        .append(annotation.name())
                        .append("\":\"")
                        .append(field.get(obj))
                        .append("\",");
            }
        }

        if (json.charAt(json.length() - 1) == ',') {
            json.deleteCharAt(json.length() - 1);
        }

        json.append("}");

        return json.toString();
    }
}

public class CustomJsonSerializerExample {

    public static void main(String[] args) throws Exception {

        JsonUser user = new JsonUser("Sudechha", 22);

        String json = JsonSerializer.convertToJson(user);

        System.out.println(json);
    }
}
