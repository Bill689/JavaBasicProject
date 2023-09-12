package reflect.aop;

public class GunDog implements Dog{
    @Override
    public void info() {
        System.out.println("这是一个猎狗");
    }

    @Override
    public void run() {
        System.out.println("猎狗在奔跑");
    }
}
