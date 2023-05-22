package com.innoventes.jukebox.test1.threads.synchronisation;

public class SampleClass {

    private static int sum = 0;
//    private static int serialVersionUID =

    public static synchronized void updateTheValue(int count){

        if (count < sum){
            System.out.println("Count is less than sum");
        }else{
            System.out.println("Count is greater than sum");
        }
    }
}
