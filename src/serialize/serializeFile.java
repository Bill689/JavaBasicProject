package serialize;

import java.io.*;

public class serializeFile {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\people.txt");

        try {
            try (
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
            ) {
                    People people =new People("孙悟空",500);

                    objectOutputStream.writeObject(people);


                    Object people1 = objectInputStream.readObject();

                    System.out.println(people1);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
