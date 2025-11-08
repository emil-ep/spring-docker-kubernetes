package com.innoventes.jukebox.test.youtube.abstraction;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Bmw320d("blue", "Bmw", "320d");
        vehicle.startEngine();
        vehicle.stopEngine();
    }
}
