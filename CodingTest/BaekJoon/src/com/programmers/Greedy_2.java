package com.programmers;

public class Greedy_2 {
    public static void main(String[] args){
        System.out.println(new Solution().solution("JEROEN"));
        System.out.println(new Solution().solution("JAN"));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;

            // 65 ~ 90
            // System.out.println((int)'J');
            // System.out.println((int)'A');

            int first = 0;
            int second = 0;

            for(int i = 0; i<name.length(); i++){
                char alpha = name.charAt(i);
                int a = Math.abs((int)'A' - alpha);
                int b = Math.abs((int)'Z' - alpha);

                if(a>=b){
                    first += b;
                }else{
                    first += a;
                }
                if(i!=name.length()-1)
                    first +=1;
            }

            for(int i = name.length(); i>0; i--){
                char alpha;
                if(i == name.length()){
                    alpha = name.charAt(0);
                }else{
                    alpha = name.charAt(i);
                }
                int a = Math.abs((int)'A' - alpha);
                int b = Math.abs((int)'Z' - alpha);

                if(a>=b){
                    second += b;
                }else{
                    second += a;
                }
                if(i!=1)
                    second +=1;
            }
            if(first>second)
                return second;
            else
                return first;
        }
    }
}
