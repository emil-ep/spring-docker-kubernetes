package com.innoventes.jukebox.test.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++){
            Callable callable = new CallableExample();
            randomNumberTasks[i] = new FutureTask(callable);
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++){
            try {
                System.out.println(randomNumberTasks[i].get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
