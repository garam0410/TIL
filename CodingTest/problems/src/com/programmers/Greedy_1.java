package com.programmers;

import java.util.Arrays;

public class Greedy_1 {
    public static void main(String[] args){
        System.out.println(new Solution().solution(5, new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(new Solution().solution(5, new int[]{2,4}, new int[]{3}));
        System.out.println(new Solution().solution(3, new int[]{3}, new int[]{1}));
        System.out.println(new Solution().solution(5, new int[]{2,3,4}, new int[]{1,2,3}));
    }

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n - lost.length;

            boolean[] check = new boolean[n];

            for(int i = 0; i<reserve.length;i++){
                check[reserve[i]-1] = true;
            }

            for(int i =0; i<reserve.length;i++){
                for(int j = 0; j<lost.length; j++){
                    if(reserve[i] == lost[j]){
                        check[reserve[i]-1] = false;
                        answer +=1;
                    }
                }
            }

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i = 0; i<lost.length; i++){

                if(lost[i] -2 >=0 && check[lost[i]-2] == true){
                    for(int j = 0; j<reserve.length; j++){
                        if(lost[i] == reserve[j]){
                            answer -= 1;
                            check[lost[i]-2] = true;
                            break;
                        }else
                            check[lost[i]-2] = false;
                    }
                    answer += 1;
                    //check[lost[i]-2] = false;
                }else if(lost[i] <n && check[lost[i]] == true){
                    for(int j = 0; j<reserve.length; j++){
                        if(lost[i] == reserve[j]){
                            answer -= 1;
                            check[lost[i]] = true;
                            break;
                        }else
                            check[lost[i]] = false;
                    }
                    answer +=1;
                    //check[lost[i]] = false;
                }
            }

            return answer;
        }
    }
}
