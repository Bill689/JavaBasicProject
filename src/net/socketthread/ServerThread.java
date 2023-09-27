package net.socketthread;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{

    private Socket socket;

    public ServerThread(Socket s){
        this.socket =s;
    }

    @Override
    public void run() {

        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
            BufferedReader bufferedReader =new BufferedReader(inputStreamReader);

            String line =null;
            OutputStream outputStream;
            PrintStream printStream;
            while((line=bufferedReader.readLine())!=null){
                for (Socket socket1 : MyServer.socketList) {
                     outputStream = socket1.getOutputStream();
                     printStream =new PrintStream(outputStream);
                     printStream.println(line);
                }
            }
        } catch (IOException e) {
            MyServer.socketList.remove(socket);
            e.printStackTrace();
        }
    }
}
