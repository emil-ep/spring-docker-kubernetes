package com.innoventes.jukebox.test.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++){
            WorkerThread thread = new WorkerThread("Thread " + i + " ");
            executor.execute(thread);
        }
        executor.shutdown();
    }
}
