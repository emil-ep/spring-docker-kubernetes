package com.innoventes.jukebox.test.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableMain {


    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(100, "Emil"),
                new Employee(1, "Nithya"),
                new Employee(55, "Pradeep kumar"),
                new Employee(21, "Amal Pradeep")
        );
        Collections.sort(employees);

        for (Employee employee : employees){
            System.out.println(employee.getId() + "\n");
            System.out.println(employee.getName() + "\n");
        }
    }
}
