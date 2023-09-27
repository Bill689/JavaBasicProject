package net.socketthread;

import java.io.*;
import java.net.Socket;

public class MyClient1 {

    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("127.0.0.1",30000);

        new Thread(new ClientThread(socket)).start();

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String line =null;
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream =new PrintStream(outputStream);

        while((line=bufferedReader.readLine())!=null){
            printStream.println(line);
        }
    }
}
