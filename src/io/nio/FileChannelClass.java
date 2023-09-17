package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelClass {

    public static void main(String[] args) throws Exception{

        File file =new File("D:\\file.txt");

        FileInputStream fileInputStream =new FileInputStream(file);
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream =new FileOutputStream("D:\\file2.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        MappedByteBuffer byteBuffer = fileInputStreamChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        fileOutputStreamChannel.write(byteBuffer);
        byteBuffer.clear();

        Charset charset = Charset.forName("GBK");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
        System.out.println(charBuffer);

        fileInputStreamChannel.close();
        fileOutputStreamChannel.close();


    }
}
