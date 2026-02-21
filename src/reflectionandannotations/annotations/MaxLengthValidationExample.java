package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Step 1: Define Field-Level Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

// Step 2: Apply to Field
class User {

    @MaxLength(10)
    private String username;

    public User(String username) {

        try {
            Field field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {

                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                            "Username exceeds max length of " + maxLength.value());
                }
            }

            this.username = username;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.println("Username: " + username);
    }
}

// Step 3: Test
public class MaxLengthValidationExample {

    public static void main(String[] args) {

        User user1 = new User("Neha");
        user1.display();

        // This will throw exception
        User user2 = new User("VeryLongUsername");
        user2.display();
    }
}
