package net.niosocketthread;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

public class NioServer_13 {

    private Selector selector =null;
    private final int port =30000;
    private Charset charset =Charset.forName("UTF-8");

    public void init() throws Exception{
        selector =Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress =new InetSocketAddress("127.0.0.1",30000);
        serverSocketChannel.bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(selector.select()>0){
            for (SelectionKey selectedKey : selector.selectedKeys()) {
                selector.selectedKeys().remove(selectedKey);
                if(selectedKey.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    selectedKey.interestOps(SelectionKey.OP_ACCEPT);
                }
                if(selectedKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel)selectedKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    String content ="";
                    try{
                        while(socketChannel.read(byteBuffer)>0){
                            byteBuffer.flip();
                            content =content +charset.decode(byteBuffer);
                        }
                        System.out.println(content);
                        selectedKey.interestOps(SelectionKey.OP_READ);
                    }catch (Exception e){
                        selectedKey.cancel();
                        if(selectedKey.channel()!=null){
                            selectedKey.channel().close();
                        }
                        if(content.length()>0){
                            for (SelectionKey key : selector.keys()) {
                                SelectableChannel channel = key.channel();
                                if(channel instanceof SocketChannel){
                                    SocketChannel socketChannel1 =(SocketChannel)channel;
                                    socketChannel1.write(charset.encode(content));
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new NioServer_13().init();
    }
}
