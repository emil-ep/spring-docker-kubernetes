package com.innoventes.jukebox.test.multithreading;

import java.util.HashMap;

public class A {

    private volatile int a = 0;

     void sum(int n){
        Thread t = Thread.currentThread();
        for (int i = 0; i <= 5; i++){
            System.out.println(t.getName() + " : "  + (n + i));
        }
    }

}
