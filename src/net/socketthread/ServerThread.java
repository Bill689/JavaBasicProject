package net.socketthread;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{

    private Socket socket;
    BufferedReader br =null;
    public ServerThread(Socket s) throws IOException {
        this.socket =s;
        br =new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        String content =null;
        while((content=readFromClient())!=null){
            for (Socket s : MyServer.socketList) {
                try {
                    OutputStream outputStream = s.getOutputStream();
                    PrintStream printStream =new PrintStream(outputStream);
                    printStream.println(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            MyServer.socketList.remove(socket);
        }
        return null;
    }
}
