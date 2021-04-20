package com.innoventes.jukebox.test.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {


    public static void main(String[] args) {

        HashMap<EmpHash, Integer> empHashMap = new HashMap<>();
        EmpHash john = new EmpHash(1, "John", "Nash", "Senior software Engineer");
        EmpHash cap = new EmpHash(2, "Captain", "America", "Senior software Engineer");
        EmpHash iron = new EmpHash(3, "Iron", "man", "Senior Software Engineer");

        empHashMap.put(john, 1000);
        empHashMap.put(cap, 2000);
        empHashMap.put(iron, 3000);

        Iterator<Map.Entry<EmpHash, Integer>> iterator = empHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<EmpHash, Integer> entry = iterator.next();
            System.out.println("Key :" + entry.getKey() + ", Value :" + entry.getValue() + "\n");
        }

        john.setLastName("carter");
        john.setId(4);
        System.out.println("************************************************************");
        Iterator<Map.Entry<EmpHash, Integer>> iterator2 = empHashMap.entrySet().iterator();
        while (iterator2.hasNext()){
            Map.Entry<EmpHash, Integer> entry = iterator2.next();
            System.out.println("Key :" + entry.getKey() + ", Value :" + entry.getValue() + "\n");
        }
    }
}
