package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeopleInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  //执行该方法

        System.out.println("正在执行的方法为："+method);

        if(args!=null){
            System.out.println("下面是执行该方法传入的实参为：");
            for (Object arg : args) {
                System.out.println(arg);
            }
        }else{
            System.out.println("调用该方法没有实参");
        }
        return null;
    }
}
