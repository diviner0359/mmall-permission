package com.mall.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Diviner on 2018/8/20.
 */
public class T3 {
    public static void main(String[] args) {
        try
        {
            System.out.println("本机的IP = " + InetAddress.getLocalHost());
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
}
