package com.innoventes.jukebox.test;

@FunctionalInterface
public interface FunctionalInterface1 {

    void print();

    default int sum(int a, int b){
        return a + b;
    }

    static int square(int a){
        return a * a;
    }
}
