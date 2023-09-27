package net;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlDecodeAndUrlEncodeLClass_2 {

    public static void main(String[] args) throws Exception {


        String encode = URLEncoder.encode("疯狂java讲义", "gbk");
        System.out.println(encode);

        String decode = URLDecoder.decode("%B7%E8%BF%F1java%BD%B2%D2%E5", "gbk");
        System.out.println(decode);
    }
}
