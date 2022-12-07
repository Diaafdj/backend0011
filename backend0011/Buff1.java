package com.diaafdj.backend0011;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buff1 {
    int  product = 0;
    private int capacity = 10;//定义最多生产数
    Lock lock = new ReentrantLock();
    Condition productCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();
    public void addProduct() throws InterruptedException {
        lock.lock();
        try {
            while(product == capacity){
                productCondition.await();
            }
            product++;//产品+1
            System.out.println("生产者生产了1个产品,剩余"+product+"个产品");
            consumerCondition.signal();
        } finally {
            lock.unlock();//解锁
        }
    }


    public void getProduct() throws InterruptedException {
        lock.lock();
        try {

            while(product == 0){
                consumerCondition.await();
            }
            product--;//元素实际个数-1
            System.out.println("消费者取走了1个产品,剩余"+product+"个产品");
            productCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
