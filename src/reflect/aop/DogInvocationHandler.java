package reflect.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DogInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        DogUtil dogUtil =new DogUtil();
        dogUtil.method1();
        method.invoke(target,args);   //target是实际对象，这行调用的是实际实现的方法
        dogUtil.method2();
        return null;
    }
}
