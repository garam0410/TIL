package com.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args){
        System.out.println(new Solution().longestPalindrome("babad"));
    }

    static class Solution {
        public String longestPalindrome(String s) {

            String answer = "";
            String result = "";

            String[] val = s.split("");

            for(int i = 0; i<val.length; i++){
                String first = val[i];

                if(val.length == 1){
                    result = val[0];
                    break;
                }
                if(val.length ==2){
                    if(val[0].equals(val[1]))
                        result = val[0] + val[1];
                    else
                        result = val[0];
                    break;
                }

                StringBuilder sb = new StringBuilder();
                sb.append(first);

                for(int j = i+1; j<val.length; j++){
                    sb.append(val[j]);
                    if(val[j].equals(first)){
                        if(sb.toString().equals(sb.reverse().toString())){
                            answer = sb.toString();
                        }
                        else
                            sb.reverse();
                    }
                }

                if(answer.length() == 0)
                    result = val[0];

                if(answer.length() > result.length())
                    result = answer;

                if(answer.length() == val.length){
                    result = answer;
                    break;
                }

            }
            return result;
        }
    }
}
