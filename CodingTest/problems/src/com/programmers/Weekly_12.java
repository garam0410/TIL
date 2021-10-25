package com.programmers;

public class Weekly_12 {
    public static void main(String[] args){
        System.out.println(new Solution().solution(80, new int[][]{{80, 20},{50, 40},{30, 10}}));
    }

    static class Solution {
        static boolean[] check; // 던전 입장 체크 변수
        static int max = Integer.MIN_VALUE;
        static int[][] dungeons; // 던전
        static int dungeonsSize; // 던전 갯수
        static int k; // 현재 피로도

        public int solution(int k, int[][] dungeons) {
            int answer = 0;

            this.dungeons = dungeons;
            this.k = k;
            this.dungeonsSize = dungeons.length;

            check = new boolean[k];

            rec_func(0, k);

            answer = max;

            return answer;
        }

        static void rec_func(int cnt, int hp){

            if(cnt==dungeonsSize){
                max = cnt;
                return;
            }

            for(int i = 0; i<dungeonsSize; i++){
                if(check[i] == false && dungeons[i][0] <= hp){
                    check[i] = true;
                    rec_func(cnt+1, hp - dungeons[i][1]);
                    check[i] = false;
                }
            }

            max = Math.max(max,cnt);
        }
    }
}
