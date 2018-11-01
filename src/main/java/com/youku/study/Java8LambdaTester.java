package com.youku.study;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author taylor
 * @date 2018/10/29
 */
public class Java8LambdaTester {
    public static void main(String[] args) {
        Java8LambdaTester tester = new Java8LambdaTester();

        //Type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //no decalaration
        MathOperation subtraction = (a, b) -> a - b;

        //return in braces
        MathOperation multiplication = (int a, int b) -> {return a * b;};

        //no brace, no return
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //Runnable
        Runnable race = () -> System.out.println("Hello world!");

        String[] players = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka", "David Ferrer",
            "Roger Federer", "Andy Murray",
            "Tomas Berdych", "Juan Martin Del Potro",
            "Richard Gasquet", "John Isner"};

        //no brace
        GreetingService greetingService1 = message ->
            System.out.println("hello " + message);

        //with brace
        GreetingService greetingService2 = (message) ->
            System.out.println("hello " + message);

        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");

        race.run();

        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
