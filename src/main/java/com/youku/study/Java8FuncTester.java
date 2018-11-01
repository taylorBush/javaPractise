package com.youku.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author taylor
 * @date 2018/10/29
 */
public class Java8FuncTester {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("all the number:");
        eval(list, n -> true);

        System.out.println("all the even number");
        eval(list, n -> n % 2 == 0);

        System.out.println("all the number bigger thant 3");
        eval(list, n -> n > 3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
