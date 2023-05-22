package com.innoventes.jukebox.test1.threads.threadpool;

import net.bytebuddy.utility.RandomString;


public class SleepThread implements Runnable{

    private String name;
    private volatile int sharedVar = 10;

    @Override
    public void run() {
        name = RandomString.make();
        try{
            System.out.println(name + " " + System.currentTimeMillis());
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
