package net.socketthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {

    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket =new ServerSocket(30000);
        while(true){
            Socket acceptSocket = serverSocket.accept();
            socketList.add(acceptSocket);
            new Thread(new ServerThread(acceptSocket)).start();
        }
    }

}
