package net;

import java.net.InetAddress;

public class InetAddressClass_1 {

    public static void main(String[] args) throws Exception {

        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("inetAddress是否可达:"+inetAddress.isReachable(2000));
        String canonicalHostName = inetAddress.getCanonicalHostName();
        System.out.println("canonicalHostName:"+canonicalHostName);
        String hostName = inetAddress.getHostName();
        System.out.println("hostName:"+hostName);
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("hostAddress:"+hostAddress);

        InetAddress inetAddress1 = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println("inetAddress1是否可达："+inetAddress1.isReachable(5000));
        String canonicalHostName1 = inetAddress1.getCanonicalHostName();
        System.out.println("canonicalHostName:"+canonicalHostName1);
        String hostName1 = inetAddress1.getHostName();
        System.out.println("hostName:"+hostName1);
        String hostAddress1 = inetAddress1.getHostAddress();
        System.out.println("hostAddress:"+hostAddress1);


    }
}
