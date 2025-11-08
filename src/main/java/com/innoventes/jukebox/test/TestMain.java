package com.innoventes.jukebox.test;

import java.util.HashMap;
import java.util.Map;

public class TestMain {


    public static void main(String[] args) {

        Map<TestEmployee, Integer> employeeMap = new HashMap<>();
        TestEmployee e1 = new TestEmployee("Emil", 1);
        TestEmployee e2 = new TestEmployee("Nithya", 2);
        employeeMap.put(e1, 28);
        employeeMap.put(e2, 24);
        TestEmployee e3 = new TestEmployee("Rajasree", 1);
        employeeMap.put(e3, 51);
//        e3.setId(1);

        System.out.println("E1 : " + employeeMap.get(e1));
        System.out.println("E2 : " + employeeMap.get(e2));
        System.out.println("E3 : " + employeeMap.get(e3));

        InterfaceTestClass testClass = new InterfaceTestClass();
        testClass.print();

        FunctionalInterface1 interface1 = new InterfaceTestClass();
        interface1.print();
        FunctionalInterface2 interface2 = new InterfaceTestClass();
        interface2.print();

        FunctionalInterface1 func = () -> System.out.println("Printing");
        func.print();
        System.out.println(func.sum(1, 2));

        System.out.println(FunctionalInterface1.square(2));

    }
}
