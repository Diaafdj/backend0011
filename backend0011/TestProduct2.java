package com.diaafdj.backend0011;

public class TestProduct2 {
    public static void main(String[] args) {
        Buff1 buff=new Buff1();
        Thread producerThread =new Thread(new Producer2(buff));
        Thread consumerThread= new Thread(new Consumer2(buff));
        producerThread.start();
        consumerThread.start();
    }
}
