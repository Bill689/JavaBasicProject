package io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsyncFileChannelWriteClass {


    public static void main(String[] args) throws Exception {

        Path path = Paths.get("D:\\file.txt");

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        long position =0L;

        byteBuffer.put("aaabbbcccdddeeefff".getBytes());

        byteBuffer.flip();

        fileChannel.write(byteBuffer, position, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(result);
                attachment.flip();
                byte[] bytes =new byte[attachment.limit()];
                attachment.get(bytes);
                attachment.clear();
                System.out.println(new String(bytes));
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });


        byteBuffer.clear();
        fileChannel.close();
    }
}
