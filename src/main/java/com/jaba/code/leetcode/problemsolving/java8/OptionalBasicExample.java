package com.jaba.code.leetcode.problemsolving.java8;

import java.text.MessageFormat;
import java.util.Optional;

public class OptionalBasicExample {

    public static void main(String[] args) {
        Optional<String> gender = Optional.of("Male");

        String answer1 = "Yes";
        String answer2 = null;

        System.out.println(MessageFormat.format("Non-Empty Optional: {0}, gender value: {1}", gender, gender.get()));
        System.out.println(MessageFormat.format("Empty Optional: {0}", Optional.empty()));

        System.out.println(MessageFormat.format("Non-Empty Of.Nullable Optional: {0}", Optional.ofNullable(answer1)));
        System.out.println(MessageFormat.format("Empty Of.Nullable Optional: {0}", Optional.ofNullable(answer2)));

        //Null pointer exception
        System.out.println(Optional.of(answer2));
    }
}
