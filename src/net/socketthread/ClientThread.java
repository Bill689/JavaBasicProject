package net.socketthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable{
    private Socket socket;
    BufferedReader bufferedReader =null;
    public ClientThread(Socket s) throws IOException {
        this.socket =s;
        bufferedReader =new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {

        try{
            String content =null;
            while((content=bufferedReader.readLine())!=null){
                System.out.println(content);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
