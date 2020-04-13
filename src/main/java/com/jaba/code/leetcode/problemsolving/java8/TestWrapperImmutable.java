package com.jaba.code.leetcode.problemsolving.java8;

public class TestWrapperImmutable {

    private static void changeValue(Integer i) {
        i = 20;
    }

    private static void changeValue(MutableInteger i) {
        i.integer = 20;
    }

    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(i);
        changeValue(i);
        System.out.println(i);

        MutableInteger integer = new MutableInteger();
        integer.integer = 10;
        System.out.println(integer.integer);
        changeValue(integer);
        System.out.println(integer.integer);

    }
}

class MutableInteger {
    int integer;
}
