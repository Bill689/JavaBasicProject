package io.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class RandomFileChannelClass {

    public static void main(String[] args) throws Exception{

        File file=new File("D:\\file.txt");
        RandomAccessFile randomAccessFile =new RandomAccessFile(file,"rw");
        FileChannel randomAccessFileChannel = randomAccessFile.getChannel();

        MappedByteBuffer byteBuffer = randomAccessFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        randomAccessFileChannel.position(file.length());
        randomAccessFileChannel.write(byteBuffer);

        byteBuffer.clear();

        randomAccessFileChannel.close();

        Charset charset = Charset.forName("GBK");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
        System.out.println(charBuffer);


    }
}
