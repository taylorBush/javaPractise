package com.youku.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author taylor
 * @date 2018/11/1
 */
public class Java8OptionalTester {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);
        List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = null;

        Optional<Integer> a = Optional.ofNullable(value1);
        System.out.println(a);
        System.out.println(a.toString());
        Optional<Integer> b = Optional.of(value2);
        System.out.println(b);
        System.out.println(b.toString());

        System.out.println(Optional.ofNullable(listA).get());
        System.out.println(Optional.ofNullable(listB));
        System.out.println(Optional.ofNullable(listC));

        System.out.println(sum(a, b));
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("parameter 1 is exist: " + a.isPresent());
        System.out.println("parameter 2 is exist: " + b.isPresent());

        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return value1 + value2;
    }
}
