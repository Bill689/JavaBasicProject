package net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection_POST_8 {

    public static void main(String[] args) throws Exception{

        String urlStr ="https://www.liaoxuefeng.com/wiki/1252599548343744/1305207629676577";

        URL url =new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        urlConnection.setRequestProperty("accept","*/*");

        urlConnection.setDoInput(true);              //通过URLConnection发起post请求
        urlConnection.setDoOutput(true);

        OutputStream urlConnectionOutputStream = urlConnection.getOutputStream();
        PrintWriter printWriter =new PrintWriter(urlConnectionOutputStream);

        printWriter.write("参数信息");
        printWriter.flush();

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
        BufferedReader bufferedReader =new BufferedReader(inputStreamReader);

        String result ="";
        String line;
        while((line=bufferedReader.readLine())!=null){
            result =result +"\n" +line;
        }
        System.out.println(result);

        urlConnection.disconnect();
        printWriter.close();
        bufferedReader.close();

    }
}
