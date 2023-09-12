package reflect.aop;

import java.lang.reflect.Proxy;

public class DogTest {

    public static void main(String[] args) {

        Dog dog =new GunDog();

        DogInvocationHandler dogInvocationHandler =new DogInvocationHandler();

        dogInvocationHandler.setTarget(dog);

        Dog instance = (Dog) Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), dogInvocationHandler);

        instance.info();

        instance.run();

    }
}
