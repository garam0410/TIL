package com.leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args){
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("IX"));
        System.out.println(new Solution().romanToInt("LVIII"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }

    static class Solution {
        public int romanToInt(String s) {
            int answer = 0;

            HashMap<String, Integer> roman = new HashMap<String, Integer>();
            String[] symbol = new String[]{"I","V","X","L","C","D","M"};
            int[] value = new int[]{1,5,10,50,100,500,1000};

            for(int i = 0; i<symbol.length; i++){
                roman.put(symbol[i],value[i]);
            }

            String[] val = s.split("");

            for(int i = 0; i<val.length; i++){
                try{
                    if(roman.get(val[i])<roman.get(val[i+1])){
                        answer = answer + roman.get(val[i+1]) - roman.get(val[i]);
                        i++;
                    }
                    else{
                        answer += roman.get(val[i]);
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    answer += roman.get(val[i]);
                }
            }

            return answer;
        }
    }
}
