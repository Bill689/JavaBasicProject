package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ChannelReadFileClass {

    public static void main(String[] args) throws Exception{

        File file =new File("D:\\file.txt");
        FileInputStream fileInputStream =new FileInputStream(file);
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        while(fileInputStreamChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            Charset charset = Charset.forName("GBK");
            CharsetDecoder charsetDecoder = charset.newDecoder();
            CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
            System.out.println(charBuffer);
            byteBuffer.clear();
        }
        fileInputStreamChannel.close();
    }
}
