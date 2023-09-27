package net.socketthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable{

    private Socket socket;

    public ClientThread(Socket s){
        this.socket =s;
    }
    @Override
    public void run() {

        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
            BufferedReader bufferedReader =new BufferedReader(inputStreamReader);

            String line =null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
