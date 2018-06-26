package com.practice.demo.threadExample;


public class RunnableExample implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()
                    + "\twith Runnable: MyRunnableImplementation runs..." + i);
        }
    }
}
