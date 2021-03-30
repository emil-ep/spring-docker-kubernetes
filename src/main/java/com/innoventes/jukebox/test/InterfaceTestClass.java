package com.innoventes.jukebox.test;

public class InterfaceTestClass implements FunctionalInterface1, FunctionalInterface2{


    @Override
    public void print() {
        System.out.println("Printing from functional interface");
    }
}
