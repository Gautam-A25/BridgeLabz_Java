package reflectionandannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define Class-Level Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

// Step 2: Simulate User Context
class UserContext {
    static String currentUserRole = "USER";   // Change to ADMIN to test
}

// Step 3: Apply Annotation
@RoleAllowed("ADMIN")
class AdminService {

    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }
}

// Step 4: Access Controller
public class RoleBasedAccessExample {

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();

        if (service.getClass().isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed =
                    service.getClass().getAnnotation(RoleAllowed.class);

            if (UserContext.currentUserRole.equals(roleAllowed.value())) {

                Method method = service.getClass().getMethod("deleteUser");
                method.invoke(service);

            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
