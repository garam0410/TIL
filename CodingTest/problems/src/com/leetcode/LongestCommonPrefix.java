package com.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args){
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            String answer = "";

            for(int i = 0; i<=200; i++){
                try{
                    char check = strs[0].charAt(i);
                    int j = 0;
                    for(j = 0; j<strs.length; j++){
                        if(j==0) continue;

                        if(strs[j].charAt(i) == check)
                            continue;
                        else
                            break;
                    }
                    if(j==strs.length)
                        answer += check;
                    else
                        break;

                }catch(Exception e){
                    break;
                }
            }

            return answer;
        }
    }
}
