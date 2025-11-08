package com.innoventes.jukebox.test1.threads.synchronisation;

import org.apache.commons.lang3.RandomUtils;

public class SampleClass {

    private static int sum = 0;
//    private static int serialVersionUID =

    public static synchronized void updateTheValue(int count) {
        sum = RandomUtils.nextInt(0, 1000);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException ex){
            System.out.println("exception caught");
        }
        if (count < sum){
            System.out.println("Count is less than sum");
        }else{
            System.out.println("Count is greater than sum");
        }
    }
}
