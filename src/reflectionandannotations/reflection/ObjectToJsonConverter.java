package reflectionandannotations.reflection;

import java.lang.reflect.Field;

/*
 * Convert object to JSON-like string using Reflection
 */
class Product {
    private String name = "Laptop";
    private int price = 50000;
}

public class ObjectToJsonConverter {

    public static String convertToJson(Object object) {

        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {

            fields[i].setAccessible(true);

            try {
                json.append("\"")
                        .append(fields[i].getName())
                        .append("\":\"")
                        .append(fields[i].get(object))
                        .append("\"");

                if (i < fields.length - 1) {
                    json.append(",");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");

        return json.toString();
    }

    public static void main(String[] args) {

        Product product = new Product();

        String json = convertToJson(product);

        System.out.println(json);
    }
}

