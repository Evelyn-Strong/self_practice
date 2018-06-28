package com.practice.demo.threadExample.threadPool;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        //something logical here
        return t;
    }
}
