package reflectionandannotations.reflection;

import java.lang.reflect.Field;

/*
 * Class containing private static field
 */
class Configuration {

    private static String API_KEY = "ORIGINAL_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {

    public static void main(String[] args) {

        try {

            Class<?> clazz = Configuration.class;

            Field field = clazz.getDeclaredField("API_KEY");

            field.setAccessible(true);

            // Modify static field (null for static object reference)
            field.set(null, "UPDATED_SECRET_KEY");

            System.out.println("Updated API Key: " +
                    Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

