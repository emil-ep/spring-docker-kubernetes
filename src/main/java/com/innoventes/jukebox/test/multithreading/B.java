package com.innoventes.jukebox.test.multithreading;

public class B extends Thread{

    A a = new A();

    @Override
    public void run() {
        a.sum(10);
    }
}
