package com.innoventes.jukebox.test.multithreading;

public class Test {

    public static void main(String[] args) {
        // Creating an object of class B
        B b = new B();

        // Initializing instance t1 of Thread
        // class with object of class B
        Thread t1 = new Thread(b);

        // Initializing instance t2 of Thread
        // class with object of class B
        Thread t2 = new Thread(b);

        // Intializing thread t1 with name
        //'Thread A'
        t1.setName("Thread A");

        // Initializing thread t2 with name
        //'Thread B'
        t2.setName("Thread B");

        // Starting thread instance t1 and t2
        t1.start();
        t2.start();

        Thread t = new Thread(() -> System.out.println("Something"));
        t.start();

    }

}
