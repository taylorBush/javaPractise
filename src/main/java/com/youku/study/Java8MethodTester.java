package com.youku.study;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taylor
 * @date 2018/10/29
 */
public class Java8MethodTester {
    public static void main(String[] args) {
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("alibaba");

        names.forEach(System.out::println);
    }
}
