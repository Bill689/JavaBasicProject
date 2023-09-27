package net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_9 {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket =new ServerSocket(30000);

        while(true){
            Socket acceptSocket = serverSocket.accept();
            OutputStream outputStream = acceptSocket.getOutputStream();
            PrintStream printStream =new PrintStream(outputStream);
            printStream.println("您好，这是来自服务器的新年祝福");
            printStream.close();
            acceptSocket.close();
        }
    }
}
