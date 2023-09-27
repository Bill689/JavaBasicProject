package net;

import java.net.URL;

public class URLClass_3 {

    public static void main(String[] args) throws Exception {

        String urlStr ="https://www.liaoxuefeng.com/wiki/1252599548343744/1305207629676577";

        URL url =new URL(urlStr);         //获取url的属性

        String file = url.getFile();
        System.out.println("file = " + file);
        String host = url.getHost();
        System.out.println("host = " + host);
        String path = url.getPath();
        System.out.println("path = " + path);
        int port = url.getPort();
        System.out.println("port = " + port);
        String protocol = url.getProtocol();
        System.out.println("protocol = " + protocol);
        String query = url.getQuery();
        System.out.println("query = " + query);


    }
}
