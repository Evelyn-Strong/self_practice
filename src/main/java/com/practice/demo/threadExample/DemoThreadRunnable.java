package com.practice.demo.threadExample;

public class DemoThreadRunnable implements Runnable {

    private ThreadLocal mythreadLocal = new ThreadLocal();

//    public DemoThreadRunnable(String threadLocalVariable){
//        mythreadLocal.set(threadLocalVariable);
//    }

    public Object getThreadLocalValue(){
        return this.mythreadLocal.get();
    }

    @Override
    public void run(){
        int value = (int) (Math.random() * 100D);
        System.out.println(value);
        mythreadLocal.set(value);

        mythreadLocal.set("test");


        try {
            Thread.sleep(2000);
        }catch (InterruptedException e ){

        }
        System.out.println(Thread.currentThread().getName() + " .....ThreadLocal Variable:: "   + mythreadLocal.get());
    }

}
