package com.innoventes.jukebox.test.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorMain {


    public static void main(String[] args) {

        List<Group> groups = Arrays.asList(
                new Group("Linkin Park", 100),
                new Group("Led zeppelin", 1),
                new Group("Metallica", 21),
                new Group("Iron maiden", 53)
        );
        CompareById compareById = new CompareById();
        CompareByName compareByName = new CompareByName();

       Collections.sort(groups, compareById);

       for (Group group : groups){
           System.out.println(group.getId() + "\n");
       }
    }
}
