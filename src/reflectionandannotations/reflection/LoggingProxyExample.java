package reflectionandannotations.reflection;

import java.lang.reflect.*;

/*
 * Dynamic Proxy Example
 */

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {

    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}

class LoggingInvocationHandler implements InvocationHandler {

    private Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy,
                         Method method,
                         Object[] args) throws Throwable {

        System.out.println("Calling method: " + method.getName());

        return method.invoke(target, args);
    }
}

public class LoggingProxyExample {

    public static void main(String[] args) {

        Greeting original = new GreetingImpl();

        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(original)
        );

        proxyInstance.sayHello("Sudechha");
    }
}
