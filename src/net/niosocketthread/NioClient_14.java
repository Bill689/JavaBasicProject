package net.niosocketthread;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NioClient_14 {

    private Selector selector =null;
    private static int port =30000;
    private Charset charset =Charset.forName("UTF-8");
    private SocketChannel socketChannel =null;

    public void init() throws Exception{
        selector =Selector.open();
        InetSocketAddress inetSocketAddress =new InetSocketAddress("127.0.0.1",port);
        socketChannel = SocketChannel.open(inetSocketAddress);
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);

        new ClientThread2().start();

        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line =scanner.nextLine();
            socketChannel.write(charset.encode(line));
        }
    }

    private class ClientThread2 extends Thread{
        public void run(){
            try{
                while(selector.select()>0){
                    for (SelectionKey selectedKey : selector.selectedKeys()) {
                        selector.selectedKeys().remove(selectedKey);
                        if(selectedKey.isReadable()){
                            SocketChannel socketChannel =(SocketChannel)selectedKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            String content ="";
                            while(socketChannel.read(byteBuffer)>0){
                                socketChannel.read(byteBuffer);
                                byteBuffer.flip();
                                content =content +charset.decode(byteBuffer);
                            }
                            System.out.println(content);
                            selectedKey.interestOps(SelectionKey.OP_READ);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new NioClient_14().init();
    }
}


