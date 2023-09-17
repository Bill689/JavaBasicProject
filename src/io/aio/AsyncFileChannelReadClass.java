package io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncFileChannelReadClass {

    public static void main(String[] args) throws Exception{

        Path path = Paths.get("D:\\file.txt");

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        long position =0L;

        Future<Integer> future = fileChannel.read(byteBuffer, position);

        Integer integer = future.get();

        System.out.println(integer);

        byteBuffer.flip();

        byte[] bytes =new byte[byteBuffer.limit()];

        byteBuffer.get(bytes);

        System.out.println(new String(bytes));

        byteBuffer.clear();

        fileChannel.close();


    }
}
