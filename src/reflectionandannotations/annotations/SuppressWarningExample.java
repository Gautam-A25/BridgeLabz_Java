package reflectionandannotations.annotations;

import java.util.ArrayList;

public class SuppressWarningExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();  // Raw type (no generics)

        list.add("Hello");
        list.add(123);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
