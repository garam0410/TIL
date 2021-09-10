package com.programmers;

public class Greedy_3 {
    public static void main(String[] args){
        System.out.println(new Solution().solution("1924",2));
        System.out.println(new Solution().solution("1231234",3));
        System.out.println(new Solution().solution("4177252841",4));
    }

    static class Solution {
        public String solution(String number, int k) {
            String answer = "";

            StringBuilder sb = new StringBuilder(number);

            int cnt = 0;
            int i = 0;

            while(cnt != k){
                try{
                    if(Integer.parseInt(sb.substring(i,i+1).toString()) < Integer.parseInt(sb.substring(i+1,i+2).toString())){
                        sb.replace(i,i+1," ");
                        i++;
                        cnt++;
                    }else if(Integer.parseInt(sb.substring(i,i+1).toString()) == Integer.parseInt(sb.substring(i+1,i+2).toString())){
                        i++;
                    }
                    else{
                        sb.replace(i+1,i+2," ");
                        i++;
                        cnt++;
                    }
                }catch(Exception e){
                    i++;
                }
            }

            return sb.toString();
        }
    }
}
