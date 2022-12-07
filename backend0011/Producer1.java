package com.diaafdj.backend0011;

public class Producer1 implements Producer{
    Buff buff;
    public Producer1(Buff buff){
        this.buff=buff;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch (InterruptedException ignored){

            }
            buff.addProduct();
        }
    }
}
