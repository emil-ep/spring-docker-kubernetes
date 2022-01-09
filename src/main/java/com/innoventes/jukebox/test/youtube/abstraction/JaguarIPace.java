package com.innoventes.jukebox.test.youtube.abstraction;

public class JaguarIPace extends Vehicle{
    @Override
    protected void startEngine() {
        System.out.println("Jaguar Ipace started");
    }

    public JaguarIPace(String color, String brand, String name) {
        super(color, brand, name);
    }
}
