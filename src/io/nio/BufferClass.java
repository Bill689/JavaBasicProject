package io.nio;

import java.nio.CharBuffer;

public class BufferClass {

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(8);
        System.out.println(charBuffer.capacity());
        System.out.println(charBuffer.limit());
        System.out.println(charBuffer.position());
        System.out.println(charBuffer.length());

        charBuffer.put("a");
        charBuffer.put('b');
        charBuffer.put('c');

        System.out.println("插入三个元素后，position =" +charBuffer.position());

        charBuffer.flip();
        System.out.println("执行flip后，limit=" +charBuffer.limit());
        System.out.println(charBuffer.position());

        System.out.println("取出第一个元素："+charBuffer.get());
        System.out.println("position=" +charBuffer.position());
        System.out.println(charBuffer.length());

        charBuffer.clear();
        System.out.println("执行clear后，limit="+charBuffer.limit());
        System.out.println(charBuffer.position());

        System.out.println(charBuffer.get(2));
        System.out.println(charBuffer.position());



    }
}
