package com.innoventes.jukebox.test1.functionalinterface;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ItCompany itCompany = (name) -> RandomUtils.nextInt(0, 100)/2 == 0;

        String[] names = new String[] {"Akshay", "Gokul", "Harold", "Ajay", "Sam", "Anjana"};

        Arrays.stream(names).filter(itCompany::conductInterview).forEach(System.out::println);

        System.out.println(" -------------- ");
        Comparator<String> comparator = (s1, s2) -> s1.length() > s2.length()? 1: -1;
        Arrays.stream(names).sorted(comparator).collect(Collectors.toList()).forEach(System.out::println);
    }
}
