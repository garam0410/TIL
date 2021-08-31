package com.leetcode;

public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(new Solution().reverse(-123));
    }

    static class Solution {
        public int reverse(int x) {
            int answer = 0;

            StringBuilder sb = new StringBuilder(String.valueOf(x));

            try{
                if(x>=0){
                    answer = Integer.parseInt(sb.reverse().toString());
                }
                else{
                    answer = 0 - Integer.parseInt(sb.reverse().substring(0,sb.length()-1).toString());
                }


            }catch(Exception e){
                answer = 0;
            }

            return answer;
        }
    }
}
