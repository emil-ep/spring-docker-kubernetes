package com.innoventes.jukebox.test.treeset;

import java.util.TreeSet;

public class TreesetTest {


    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(9);
        treeSet.add(8);
        treeSet.add(11);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(2);
//        treeSet.setcomparator();

        treeSet.forEach(System.out::println);
    }
}
