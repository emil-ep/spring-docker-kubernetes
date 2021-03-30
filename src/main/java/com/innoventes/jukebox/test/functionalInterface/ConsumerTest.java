package com.innoventes.jukebox.test.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Alabama", "Sydney", "New york", "London");
        cities.forEach(printConsumer);

        List<String> stringList = Arrays.asList("Alabama", "Sydney", "New york", "London");
        stringList.forEach(printConsumer);

        //Chain of consumers example
        List<String> names = Arrays.asList("Anand", "Arun", "Anandu", "Bineesh");
        Consumer<List<String>> upperCaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printListConsumer = list -> list.stream().forEach(System.out::println);
        upperCaseConsumer.andThen(printListConsumer).accept(names);

    }
}
