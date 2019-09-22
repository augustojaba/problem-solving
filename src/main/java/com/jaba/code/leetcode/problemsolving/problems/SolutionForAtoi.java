package com.jaba.code.leetcode.problemsolving.problems;

public class SolutionForAtoi {

	public static int myAtoi1(String str) {
		
		//^[-|\+]?\d*\.?\d*[\s|\w]*

		int result = 0;
		str = str.trim();

		if (str == null || str.isEmpty() || !str.matches("^[-|\\+]?\\d+\\.?\\d*.*")) {
			return result;
		}

		int i = str.length() - 1;
		int matisse = 0;

		while (i >= 0/* && str.charAt(i) != '-' && str.charAt(i) != '+'*/) {

			if (str.substring(i, i+1).matches("\\d")) {

				if (str.charAt(0) != '-') {
					if (result + Math.pow(10, matisse) < Integer.MAX_VALUE)
						result += Integer.parseInt(str.substring(i, i+1)) * Math.pow(10, matisse);
					else if(Integer.parseInt(str.substring(i, i+1)) != 0)
						return Integer.MAX_VALUE;
				} else {
					if (result - Math.pow(10, matisse) > Integer.MIN_VALUE)
						result -= Integer.parseInt(str.substring(i, i+1)) * Math.pow(10, matisse);
					else if(Integer.parseInt(str.substring(i, i+1)) != 0)
						return Integer.MIN_VALUE;
				}
				
				matisse++;
			} else if(!str.substring(i, i+1).matches("[-|\\+]") ||
					(str.substring(i, i+1).matches("[-|\\+]") && i > 0)) {
				result = 0;
				matisse = 0;
			}

			i--;
		}
		
		return result;
	}
	
	public static int myAtoi(String str) {
	    int index = 0, sign = 1, total = 0;
	    //1. Empty string
	    if(str.length() == 0) return 0;

	    //2. Remove Spaces
	    while(str.charAt(index) == ' ' && index < str.length())
	        index ++;

	    //3. Handle signs
	    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
	        sign = str.charAt(index) == '+' ? 1 : -1;
	        index ++;
	    }
	    
	    //4. Convert number and avoid overflow
	    while(index < str.length()){
	        int digit = str.charAt(index) - '0';
	        if(digit < 0 || digit > 9) break;

	        //check if total will be overflow after 10 times and add digit
	        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

	        total = 10 * total + digit;
	        index ++;
	    }
	    return total * sign;
	}

	public static void main(String[] args) {
		System.out.println(SolutionForAtoi.myAtoi("2147483648"));
		System.out.println(SolutionForAtoi.myAtoi("-2147483647"));
		System.out.println(SolutionForAtoi.myAtoi("0-1"));
		System.out.println(SolutionForAtoi.myAtoi("+-2"));
		System.out.println(SolutionForAtoi.myAtoi("+2+"));
		System.out.println(SolutionForAtoi.myAtoi("-2+"));
		System.out.println(SolutionForAtoi.myAtoi("-2-"));
		System.out.println(SolutionForAtoi.myAtoi("42"));
		System.out.println(SolutionForAtoi.myAtoi("   -42"));
		System.out.println(SolutionForAtoi.myAtoi("   -42  sd  sd"));
		System.out.println(SolutionForAtoi.myAtoi("4193 with words"));
		System.out.println(SolutionForAtoi.myAtoi("words and 987"));
		System.out.println(SolutionForAtoi.myAtoi("-91283472332"));
		System.out.println(SolutionForAtoi.myAtoi("-2147483648"));
		System.out.println(SolutionForAtoi.myAtoi("-2147483646"));
		System.out.println(SolutionForAtoi.myAtoi("2147483647"));
		System.out.println(SolutionForAtoi.myAtoi("  0000000000012345678"));
		System.out.println(SolutionForAtoi.myAtoi("+1"));
		System.out.println(SolutionForAtoi.myAtoi("3.14159"));
		
	}

}
