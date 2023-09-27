package net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class UrlClass_6 {

    public static void main(String[] args) throws Exception {

        String urlStr ="https://www.liaoxuefeng.com/wiki/1252599548343744/1305207629676577";

        URL url =new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        urlConnection.setConnectTimeout(5000);               //设置和获取urlConnection的属性
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("accept","*/*");


        Object content = urlConnection.getContent();
        System.out.println(content);

        int fileSize = urlConnection.getContentLength();
        System.out.println(fileSize);

        String contentEncoding = urlConnection.getContentEncoding();
        System.out.println(contentEncoding);

        String contentType = urlConnection.getContentType();
        System.out.println(contentType);

        long date = urlConnection.getDate();
        System.out.println(new Date(date));

        long expiration = urlConnection.getExpiration();
        System.out.println(new Date(expiration));

        long lastModified = urlConnection.getLastModified();
        System.out.println(new Date(lastModified));


    }
}
