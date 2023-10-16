package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient16 {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket =new DatagramSocket(30001);

        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            byte[] bytes = line.getBytes();
            DatagramPacket datagramPacket =new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),30000);
            datagramSocket.send(datagramPacket);

            byte[] bytes2 =new byte[4096];
            DatagramPacket datagramPacket1 =new DatagramPacket(bytes2,bytes2.length);
            datagramSocket.receive(datagramPacket1);
            System.out.println(new String(datagramPacket1.getData(),0,datagramPacket1.getLength()));
        }
        datagramSocket.close();
    }
}
