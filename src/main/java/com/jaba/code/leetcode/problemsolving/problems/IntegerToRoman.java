package com.jaba.code.leetcode.problemsolving.problems;

public class IntegerToRoman {

    public String intToRoman(int num) {
        int grade = 0;
        StringBuilder result = new StringBuilder();

        String[][] table = {
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"M", "MM", "MMM"}
        };

        while (num > 0) {
            int radix = num % 10;

            if (radix == 0) {
                grade++;
                num /= 10;
                continue;
            } else {
                radix = radix -1;
            }

            result.insert(0, table[grade][radix]);
            grade++;
            num /= 10;
        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(20));
        System.out.println(new IntegerToRoman().intToRoman(10));
        System.out.println(new IntegerToRoman().intToRoman(18));
        System.out.println(new IntegerToRoman().intToRoman(58));
        System.out.println(new IntegerToRoman().intToRoman(3999));
        System.out.println(new IntegerToRoman().intToRoman(0));
        System.out.println(new IntegerToRoman().intToRoman(1997));
    }
}
