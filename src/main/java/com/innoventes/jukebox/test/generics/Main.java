package com.innoventes.jukebox.test.generics;

public class Main {

    public static void main(String[] args) {
        OrderedPair<Integer> pair = new OrderedPair<>();
        pair.setT(6);

        OrderedPair<Integer> secondPair = new OrderedPair<>();
        secondPair.setT(7);
    }

    public static <T extends Comparable<T>> int counterGreaterThan(T[] array, T elem){
        int count = 0;
        for(T e: array){
            if (e.compareTo(elem) > 0){
                ++count;
            }
        }
        return count;
    }
}
