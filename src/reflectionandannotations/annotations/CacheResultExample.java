package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

// Step 2: Service Class
class MathService {

    @CacheResult
    public int slowSquare(int number) {

        try {
            Thread.sleep(2000);  // Simulate heavy computation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return number * number;
    }
}

// Step 3: Cache Engine
class CacheProcessor {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object process(Object obj, String methodName, Object... args) throws Exception {

        String key = methodName + args[0];

        if (cache.containsKey(key)) {
            System.out.println("Returning cached result...");
            return cache.get(key);
        }

        Method method = obj.getClass().getMethod(methodName, int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {

            Object result = method.invoke(obj, args);

            cache.put(key, result);

            return result;
        }

        return method.invoke(obj, args);
    }
}

// Step 4: Test
public class CacheResultExample {

    public static void main(String[] args) throws Exception {

        MathService service = new MathService();

        System.out.println("First call:");
        System.out.println(CacheProcessor.process(service, "slowSquare", 5));

        System.out.println("\nSecond call:");
        System.out.println(CacheProcessor.process(service, "slowSquare", 5));
    }
}
