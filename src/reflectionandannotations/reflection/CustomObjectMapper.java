package reflectionandannotations.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/*
 * Custom Object Mapper using Reflection
 */
class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz,
                                 Map<String, Object> properties) {

        try {

            T object = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {

                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(object, entry.getValue());
            }

            return object;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Sudechha");
        map.put("age", 22);

        User user = toObject(User.class, map);

        System.out.println(user);
    }
}

