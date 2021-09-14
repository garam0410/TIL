package com.programmers;

import java.util.*;

public class 완전탐색_2 {

    public static void main(String[] args){
        //System.out.println(new Solution().solution("17"));
        System.out.println(new Solution().solution("011"));
    }

    static class Solution {
        static ArrayList<Integer> arr = new ArrayList<>();
        static boolean[] selected, used;
        static String[] number;

        public int solution(String numbers) {
            int answer = 0;

            //중복을 허용하지 않고, 고르기
            number = numbers.split("");
            Arrays.sort(number, Comparator.reverseOrder());

            selected = new boolean[number.length+1];
            used = new boolean[number.length+1];

            for(int i = 0; i<number.length; i++){
                // 최대 자릿수,
                rec_func(i+1, 0, "", 0);
            }

            try{
                answer = arr.size();
            }catch(Exception e){
                return 0;
            }

            return answer;
        }

        static void rec_func(int maxCnt, int currentCnt, String value,int idx){
            if(currentCnt==maxCnt){ // 자릿수가 채워지면
                int val = Integer.parseInt(value);
                if(checkSosu(value) && !arr.contains(val)){
                    arr.add(val);
                }
            }else{ // 다음 선택할 숫자 고르기

                for(int i = idx+1; i<=number.length; i++){
                    if(used[i] == false){
                        used[i] = true;
                        rec_func(maxCnt,currentCnt+1,value+number[i-1],i);
                        used[i] = false;
                    }
                }

            }
        }

        static boolean checkSosu(String value){
            int val = Integer.parseInt(value);

            for(int i = 2; i<val; i++){
                if(val % i == 0)
                    return false;
                else
                    return true;
            }
            return false;
        }
    }
}
