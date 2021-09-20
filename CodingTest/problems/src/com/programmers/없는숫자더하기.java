package com.programmers;

import java.util.ArrayList;

public class 없는숫자더하기 {

    public static void main(String[] args){
        System.out.println(new Solution().solution(new int []{1,2,3,4,5,6,7,8,0}));
    }

    static class Solution {
        public int solution(int[] numbers) {
            int answer = 0;

            ArrayList<Integer> arr = new ArrayList<>();

            for(int i = 0; i<numbers.length; i++){
                arr.add(numbers[i]);
            }

            for(int i = 0; i<10; i++){
                if(!arr.contains(i))
                    answer += i;
            }

            return answer;
        }
    }
}
