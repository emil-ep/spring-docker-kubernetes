package com.innoventes.jukebox.test1.threads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++){
            SleepThread sleepThread = new SleepThread();
            executorService.execute(sleepThread);
        }
        executorService.shutdown();
    }
}
