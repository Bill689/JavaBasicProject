package net;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class URLClass_4 {

    public static void main(String[] args) throws Exception {

        String urlStr ="https://www.liaoxuefeng.com/wiki/1252599548343744/1305207629676577";
        URL url =new URL(urlStr);

        InputStream inputStream = url.openStream();   //通过url读取资源文件
        FileOutputStream fileOutputStream =new FileOutputStream("D:\\file.txt");

        int hasRead =0;
        byte[] bytes =new byte[1024];

        while((hasRead =inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,hasRead);
        }

        inputStream.close();
        fileOutputStream.close();
    }
}
