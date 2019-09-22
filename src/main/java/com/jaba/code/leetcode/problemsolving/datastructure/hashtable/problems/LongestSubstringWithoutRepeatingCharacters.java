package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int result = -1;
        int index = 0;
        int iniSubstring = 0;

        while (index < s.length()) {
            int indexNewChar = index + 1 < s.length()? s.substring(iniSubstring, index + 1).indexOf(s.charAt(index + 1)) : Integer.MAX_VALUE;
            if (indexNewChar < 0) {
                index++;
            } else {
                int diff = (index - iniSubstring) + 1;
                if (diff > result) {
                    result = diff;
                }
                iniSubstring += indexNewChar + 1;

                if (index + 1 >= s.length()) {
                    break;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("au"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("a"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(null));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(\"abcabcbb\"));"));
    }
}
