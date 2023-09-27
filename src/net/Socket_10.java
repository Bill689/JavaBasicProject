package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Socket_10 {

    public static void main(String[] args) throws IOException {

        Socket socket =new Socket("127.0.0.1",30000);
        socket.setSoTimeout(200);
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
        BufferedReader bufferedReader =new BufferedReader(inputStreamReader);

        String line;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        bufferedReader.close();
        socket.close();
    }
}
