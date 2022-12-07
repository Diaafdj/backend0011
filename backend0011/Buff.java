package com.diaafdj.backend0011;

public class Buff {
    private int product=0;
    public synchronized void addProduct(){
        if(product>=10){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println("生产者生产了1个产品,剩余"+product+"个产品");
            notifyAll();
        }
    }

    public synchronized void getProduct(){
        if(this.product<=0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else {
            product--;
            System.out.println("消费者取走了1个产品,剩余"+product+"个产品");

            notifyAll();
        }
    }
}
