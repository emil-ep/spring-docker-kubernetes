package com.innoventes.jukebox.test1.threads.synchronisation;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class SampleThread implements Runnable{



    @Override
    public void run() {

        SampleClass.updateTheValue(RandomUtils.nextInt(10, 10000));
    }
}
