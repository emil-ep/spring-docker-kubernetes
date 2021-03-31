package com.innoventes.jukebox.test.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableExample implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt();
        Thread.sleep( 1000);
        return randomNumber;
    }


}
