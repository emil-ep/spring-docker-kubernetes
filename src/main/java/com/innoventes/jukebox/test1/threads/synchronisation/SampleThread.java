package com.innoventes.jukebox.test1.threads.synchronisation;

public class SampleThread implements Runnable{



    @Override
    public void run() {

        SampleClass.updateTheValue(100);
    }
}
