package com.innoventes.jukebox.test.generics;

public class OrderedPair<T>{

    private T t;

//    public OrderedPair(T t){
//        this.t = t;
//    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
