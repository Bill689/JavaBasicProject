package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class URLConnection_GET_7{

    public static void main(String[] args) throws Exception {

        String urlStr ="https://www.liaoxuefeng.com/wiki/1252599548343744/1305207629676577";

        URL url =new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        urlConnection.setRequestProperty("accept","*/*");   //通过urlConnection发起get请求
        urlConnection.connect();

        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        for (String key : headerFields.keySet()) {
            System.out.println(key+"--->"+headerFields.get(key));
        }

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader =new InputStreamReader(inputStream,"utf-8");
        BufferedReader bufferedReader =new BufferedReader(inputStreamReader);

        String result ="";
        String line;
        while((line=bufferedReader.readLine())!=null){
            result =result+"\n"+line;
        }

        System.out.println(result);
        urlConnection.disconnect();
        bufferedReader.close();


    }
}
