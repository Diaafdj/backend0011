package com.diaafdj.backend0011;

public class Consumer2 implements Consumer{
    Buff1 buff;
    public Consumer2(Buff1 buff){
        this.buff=buff;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try{
                Thread.sleep((int) (Math.random() * 1000));
            }catch (InterruptedException ignored){

            }
            try {
                buff.getProduct();
            } catch (InterruptedException ignored) {

            }
        }
    }
}
