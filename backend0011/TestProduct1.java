package com.diaafdj.backend0011;

public class TestProduct1 {
    public static void main(String[] args) {
        Buff buff=new Buff();
        Thread producerThread =new Thread(new Producer1(buff));
        Thread consumerThread= new Thread(new Consumer1(buff));
        producerThread.start();
        consumerThread.start();
    }
}
