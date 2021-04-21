package com.innoventes.jukebox.test.methodreference;

public class MethodReference {

    public static void saySomething(){
        System.out.println("Say something");
    }

    public static void main(String[] args) {
        Sayable say = MethodReference::saySomething;
    }
}
