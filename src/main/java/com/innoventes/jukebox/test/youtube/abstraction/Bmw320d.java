package com.innoventes.jukebox.test.youtube.abstraction;

public class Bmw320d extends Vehicle{


    public Bmw320d(String color, String brand, String name) {
        super(color, brand, name);
    }

    @Override
    protected void startEngine() {
        System.out.println("Bmw 320d started");

    }
}
