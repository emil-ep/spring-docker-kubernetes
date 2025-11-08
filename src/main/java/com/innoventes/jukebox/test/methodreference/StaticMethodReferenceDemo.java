package com.innoventes.jukebox.test.methodreference;

public class StaticMethodReferenceDemo {

    public StaticMethodReferenceDemo(){

    }

    public boolean numCheck(IntPredicate p, int n){
        return p.check(n);
    }

    public static void main(String[] args) {
        StaticMethodReferenceDemo demo = new StaticMethodReferenceDemo();
        boolean result;
        int num = 9;

        IntPredicate p = number -> (number % 2) == 0;
        result = demo.numCheck(p, num);
        System.out.println("Using lambda expression: " + num + " is even: " + result);

        result = demo.numCheck(IntPredicateChecker::isEven, num);
        System.out.println("Using static method reference: " + num + " is even: " + result);
    }
}
