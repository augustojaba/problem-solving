package com.jaba.code.leetcode.problemsolving.java8;

import java.text.MessageFormat;
import java.util.Optional;

public class FlatmapBasicExample {

    public static void main(String[] args) {
        Optional<String> nonEmpty = Optional.of("Male");
        Optional<String> empty = Optional.empty();

        System.out.println(MessageFormat.format("Non-Empty Optional Upper case: {0}", nonEmpty.map(String::toUpperCase)));
        System.out.println(MessageFormat.format("Empty Optional Upper case: {0}", empty.map(String::toUpperCase)));

        Optional<Optional<String>> optionalOfOptionalNonEmpty = Optional.of(Optional.of("Male"));

        System.out.println(MessageFormat.format("Optional: {0}", optionalOfOptionalNonEmpty));
        System.out.println(MessageFormat.format("Optional.map: {0}", optionalOfOptionalNonEmpty.map(x -> x.map(String::toUpperCase))));
        System.out.println(MessageFormat.format("Optional.map: {0}", optionalOfOptionalNonEmpty.flatMap(x -> x.map(String::toUpperCase))));
    }
}
