package com.innoventes.jukebox.test.youtube.abstraction;

public abstract class Vehicle {

    protected String color;

    protected String brand;

    protected String name;

    public Vehicle(String color, String brand, String name) {
        this.color = color;
        this.brand = brand;
        this.name = name;
    }

    protected abstract void startEngine();

    protected void stopEngine(){
        System.out.println("Engine stopped");
    }

}
