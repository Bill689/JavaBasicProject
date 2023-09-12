package serialize;

import java.io.Serializable;

public class People implements Serializable {

    private String name;
    private int age;

    public People(String name,int age){  //没有提供无参构造器，但依然可以序列化和反序列化
        this.name =name;
        this.age =age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
