package serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeArray {

    public static void main(String[] args) throws Exception {

        People people =new People("孙悟空",500);

        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(people);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        ByteArrayInputStream byteArrayInputStream =new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream =new ObjectInputStream(byteArrayInputStream);
        People people1 = (People)objectInputStream.readObject();
        System.out.println(people1);

        objectInputStream.close();
        objectOutputStream.close();
    }
}
