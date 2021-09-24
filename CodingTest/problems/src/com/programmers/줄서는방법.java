package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 줄서는방법 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new Solution().solution(3,5)));
    }

    static class Solution {
        static int[] answer;
        static int n;
        static long k;
        static boolean[] check;
        static int[] nums;
        static boolean out = false;
        static int current = 0;

        public int[] solution(int n, long k) {
            answer = new int[n];

            this.n = n;
            this.k = k;

            nums = new int[n];
            check = new boolean[n];

            for(int i = 0; i<n; i++){
                nums[i] = i+1;
            }

            rec_func(0, new ArrayList<Integer>());

            return answer;
        }

        static void rec_func(int cnt, ArrayList<Integer> arr){

                if(cnt==3){
                    current++;
                    if(current==k){
                        for(int i = 0; i<3; i++){
                            answer[i] = arr.get(i);
                        }
                        out = true;
                    }
                    return;
                }
                else{
                    for(int i = 0; i<n; i++){
                        if(check[i] == false){
                            check[i] = true;
                            arr.add(nums[i]);
                            rec_func(cnt+1, arr);
                            if(out == true) return;
                            arr.remove(arr.size()-1);
                            check[i] = false;
                        }
                    }
                }

            return;
        }
    }
}
