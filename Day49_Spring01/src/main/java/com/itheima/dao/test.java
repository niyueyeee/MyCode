package com.itheima.dao;

import java.util.Date;

/**
 * @author niyueyeee
 * @create 2019-04-02 17:41
 */
public class test {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(new Date());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(new Date());
                }
            }
        }).start();
    }
}
