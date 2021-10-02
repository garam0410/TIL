package com.programmers;

public class Weekly_8 {
    public static void main(String[] args){
        System.out.println(new Solution().solution(new int[][]{{60, 50}, {30,70}, {60,30},{80,40}}));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            int maxWidth = Integer.MIN_VALUE;
            int maxHeight = Integer.MIN_VALUE;

            for(int i = 0; i<sizes.length; i++){

                if(sizes[i][0] < sizes[i][1]){
                    int tmp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }

                maxWidth = Math.max(maxWidth, sizes[i][0]);
                maxHeight = Math.max(maxHeight, sizes[i][1]);
            }

            answer = maxWidth * maxHeight;

            return answer;
        }
    }
}
