package com.youku.study.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author taylor
 * @date 2018/11/13
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> stringA = Arrays.asList("hello", "world","A");
        String[] stringArray = {"hello","world","B"};
        List<String> stringB = Arrays.asList(stringArray);

        System.out.println(stringA);
        System.out.println(stringB);

        Integer[] intArray = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(intArray);
        System.out.println("list:");
        System.out.println(list.toString());

        Long[] longArray = {1L, 2L, 3L, 4L, 5L, 4L, 3L};
        Long[] idArray = new Long[]{1L, 2L, 3L, 4L, 5L, 4L, 3L};
        List<Long> idList = Arrays.asList(idArray);
        Set<Long> idSet = new HashSet<>(idList);

        System.out.println("idArray:");
        Arrays.stream(idArray).forEach(
            System.out::println
        );

        System.out.println("idList:");
        idList.stream().forEach(
            System.out::println
        );

        System.out.println("idSet:");
        idSet.stream().forEach(
            System.out::println
        );
    }
}
