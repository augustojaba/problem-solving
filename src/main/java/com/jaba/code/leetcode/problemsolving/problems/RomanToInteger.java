package com.jaba.code.leetcode.problemsolving.problems;

public class RomanToInteger {

    public int romanToInt(String s) {

        int i = 0;
        int result = 0;

        if (s == null) {
            return result;
        }

        while (i < s.length()) {

            if (s.length() > i && s.charAt(i) == 'M') {
                result += 1000;
                i++;
            }

            if (s.length() > i && s.charAt(i) == 'D') {
                result += 500;
                i++;
            }

            if (s.length() > i && s.charAt(i) == 'C') {

                if (s.length() > i+1 && s.charAt(i + 1) == 'M') {
                    result += 900;
                    i += 2;
                } else if (s.length() > i+1 && s.charAt(i + 1) == 'D') {
                    result += 400;
                    i += 2;
                } else {
                    result += 100;
                    i++;
                }

            }

            if (s.length() > i && s.charAt(i) == 'L') {
                result += 50;
                i++;
            }

            if (s.length() > i && s.charAt(i) == 'X') {

                if (s.length() > i+1 && s.charAt(i + 1) == 'C') {
                    result += 90;
                    i += 2;
                } else if (s.length() > i+1 && s.charAt(i + 1) == 'L') {
                    result += 40;
                    i += 2;
                } else {
                    result += 10;
                    i++;
                }

            }

            if (s.length() > i && s.charAt(i) == 'V') {
                result += 5;
                i++;
            }

            if (s.length() > i && s.charAt(i) == 'I') {

                if (s.length() > i+1 && s.charAt(i + 1) == 'X') {
                    result += 9;
                    i += 2;
                } else if (s.length() > i+1 &&  s.charAt(i + 1) == 'V') {
                    result += 4;
                    i += 2;
                } else {
                    result += 1;
                    i++;
                }

            }

        }

        return result;

    }

    public static void main(String[] args) {
//        System.out.println(new RomanToInteger().romanToInt(null));
//        System.out.println(new RomanToInteger().romanToInt(""));
//        System.out.println(new RomanToInteger().romanToInt("III"));
//        System.out.println(new RomanToInteger().romanToInt("IV"));
//        System.out.println(new RomanToInteger().romanToInt("IX"));
//        System.out.println(new RomanToInteger().romanToInt("LVIII"));
//        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
//        System.out.println(new RomanToInteger().romanToInt("MMCDXXV"));
        System.out.println(new RomanToInteger().romanToInt("MMM"));
    }
}
