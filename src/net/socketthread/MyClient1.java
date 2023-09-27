package net.socketthread;

import java.io.*;
import java.net.Socket;

public class MyClient1 {

    public static void main(String[] args) throws IOException {

        Socket s =new Socket("127.0.0.1",30000);

        new Thread(new ClientThread(s)).start();

        OutputStream outputStream = s.getOutputStream();
        PrintStream printStream =new PrintStream(outputStream);

        String line=null;
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        while((line=bufferedReader.readLine())!=null){
            printStream.println(line);
        }
        printStream.close();
    }
}
