package com.innoventes.jukebox.test.methodreference.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceMain {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();

        for (int i = 1; i <= 100; i ++){
            integerList.add(i);
        }

        List<WrapperInteger> wrapperList = integerList
                .stream()
                .filter(integer -> integer%2 == 0)
                .map(WrapperInteger::new)
                .collect(Collectors.toList());
        System.out.println(wrapperList);
    }
}
