package com.leetcode;

public class PalindromeNumber {

    public static void main(String[] args){
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(121));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            String before = sb.toString();
            String after = sb.reverse().toString();

            if(before.equals(after))
                return true;
            else
                return false;
        }
    }
}
