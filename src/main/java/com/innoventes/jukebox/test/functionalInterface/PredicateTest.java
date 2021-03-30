package com.innoventes.jukebox.test.functionalInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> startsWithPredicate = t -> t.startsWith("p") || t.startsWith("P");

        List<String> names = Arrays.asList("Prince Mathew", "Emil", "Sashi", "Jd");
        names.stream().filter(startsWithPredicate).forEach(System.out::println);


        Predicate<Map.Entry<Integer, String>> mapPredicate = integerStringEntry -> integerStringEntry.getKey() == 2;

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        Map<Integer, String> filterMap =  map.entrySet().stream().filter(mapPredicate).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
