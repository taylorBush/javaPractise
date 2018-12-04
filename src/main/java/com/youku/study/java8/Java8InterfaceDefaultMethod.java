package com.youku.study.java8;

/**
 * @author taylor
 * @date 2018/10/31
 */
public class Java8InterfaceDefaultMethod {
    public static void main(String[] args) {
        Vehichle vehichle = new Car();
        vehichle.print();
    }
}

interface Vehichle {
    default void print() {
        System.out.println("I am a vehichle");
    }

    static void blowHorn() {
        System.out.println("blow horn");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("I am a four wheeler");
    }
}

class Car implements Vehichle, FourWheeler {
    @Override
    public void print() {
        Vehichle.super.print();
        FourWheeler.super.print();
        Vehichle.blowHorn();
        System.out.println("I am a car");
        }
    }
