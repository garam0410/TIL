package com.leetcode;

public class StringToInteger {
    public static void main(String[] args){
        System.out.println(new Solution().myAtoi("words and 987"));
    }

    static class Solution {
        public int myAtoi(String s) {
            int answer = 0;
            int idx = 0;

            //Step 1. delete whitespace
            s = s.trim();

            //Step 2. find positive or negative
            String[] value = s.split("");

            for(int i = 0; i<value.length; i++){
                try{
                    if(value[i].equals("+") || value[i].equals("-")){
                        if(Integer.parseInt(value[i+1])>=0){
                            idx = i;

                            if(value[i].equals("+"))
                                answer = Integer.MAX_VALUE;
                            else if(value[i].equals("-"))
                                answer = Integer.MIN_VALUE;

                            break;
                        }
                    }

                    if(Integer.parseInt(value[i])>=0){
                        idx = i;
                        answer = Integer.MAX_VALUE;
                        break;
                    }
                }catch(Exception e){
                    return 0;
                }
            }

            //Step 3. find digit
            String result = "";
            for(int i = idx; i<value.length; i++){
                try{
                    if(i==idx) result += value[i];

                    else if(Integer.parseInt(value[i])>=0)
                        result += value[i];
                }catch(Exception e){
                    break;
                }
            }

            try{
                answer = Integer.parseInt(result);
            }catch(Exception e){
            }
            //answer = Integer.parseInt(result);

            return answer;
        }
    }
}
