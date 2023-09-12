package io;

import java.io.*;

public class RandomAccessFileClass {

    //向指定文件的指定位置插入内容
    public static void main(String[] args) throws IOException {

        File tempDir =new File("D:\\");
        File temp =File.createTempFile("tmp",null,tempDir);
        temp.deleteOnExit();
        try(
                RandomAccessFile raf =new RandomAccessFile("D:\\file.txt","rw");
                FileInputStream fis =new FileInputStream(temp);
                FileOutputStream fos =new FileOutputStream(temp)
                )
        {
            //把指定文件后面的内容添加到临时文件中
            raf.seek(10);
            byte[] bytes =new byte[64];
            int hasRead =0;
            while((hasRead =raf.read(bytes))>0){
                fos.write(bytes,0,hasRead);
            }

            //定位到原位置，添加内容
            raf.seek(10);
            raf.write("要添加的内容".getBytes());

            //把临时文件中的内容添加到指定文件中
            while((hasRead =fis.read(bytes))>0){
                raf.write(bytes,0,hasRead);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
