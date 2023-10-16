package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer15 {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket =new DatagramSocket(30000);

        for (int i = 0; i < 10; i++) {
            byte[] bytes1 =new byte[4096];
            DatagramPacket datagramPacket =new DatagramPacket(bytes1,bytes1.length);
            datagramSocket.receive(datagramPacket);

            byte[] bytes2 ="abcde".getBytes();
            DatagramPacket datagramPacket1 =new DatagramPacket(bytes2,bytes2.length, InetAddress.getByName("127.0.0.1"),30001);
            datagramSocket.send(datagramPacket1);
        }
        datagramSocket.close();
    }
}
