package com.leetcode;

public class ImplementstrStr {
    public static void main(String[] args){
        System.out.println(new Solution().strStr("hello","ll"));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
}
