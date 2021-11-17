package com.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Weekly_모음사전 {
    public static void main(String[] args){
//        System.out.println(new Solution().solution("AAAE"));
//        System.out.println(new Solution().solution("AAAAE"));
        System.out.println(new Solution().solution("I"));
//        System.out.println(new Solution().solution("EIO"));
    }

    static class Solution {
        static ArrayList<String> dictionary = new ArrayList<>();
        static String[] words = {"A","E","I","O","U"};

        public int solution(String word) {
            int answer = 0;

            for(int i = 1; i<=5; i++){
                rec_func(0,i,"");
            }

            Collections.sort(dictionary);

            for(int i = 0; i<dictionary.size(); i++){
                if(dictionary.get(i).equals(word)) return i+1;
            }

            return answer;
        }

        static void rec_func(int cnt, int size, String value){
            if(cnt == size){
                dictionary.add(value);
            }else{
                for(int i = 0; i<5; i++){
                    rec_func(cnt+1,size, value+words[i]);
                }
            }
        }
    }
}
