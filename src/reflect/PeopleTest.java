package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class PeopleTest {
    public static void main(String[] args) {
        InvocationHandler handler =new PeopleInvocationHandler();

        People instance = (People)Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, handler);

        instance.walk();

        instance.sayHello("name");
    }


}
