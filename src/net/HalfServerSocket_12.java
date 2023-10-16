package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HalfServerSocket_12 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket =new ServerSocket(30000);

        Socket acceptSocket = serverSocket.accept();

        OutputStream outputStream = acceptSocket.getOutputStream();
        PrintStream printStream =new PrintStream(outputStream);

        printStream.println("服务器第一行数据");
        printStream.println("服务器第二行数据");
        acceptSocket.shutdownOutput();
        System.out.println(acceptSocket.isInputShutdown());

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
        String line = bufferedReader.readLine();
        System.out.println(line);

        bufferedReader.close();
        acceptSocket.close();
        serverSocket.close();


    }
}
