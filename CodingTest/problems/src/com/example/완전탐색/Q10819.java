package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q10819 {
    static int N;
    static int[] nums;
    static ArrayList<Integer> res = new ArrayList<>();
    static ArrayList<Integer> val = new ArrayList<>();

    static boolean[] check;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        String[] tmp = bf.readLine().split(" ");

        nums = new int[N];
        check = new boolean[N];

        for(int i = 0; i<N; i++)
            nums[i] = Integer.parseInt(tmp[i]);

        rec_func(0, new int[N]);

        System.out.println(max);
    }

    static void rec_func(int cnt, int[] values){
        if(cnt == N){
            max = Math.max(max,sum(values));
            //System.out.println(Arrays.toString(values));
        }
        else{
            for(int i = 0; i<N; i++){
                if(check[i] == false){
                    check[i] = true;
                    values[cnt] = nums[i];
                    rec_func(cnt+1, values);
                    check[i] = false;
                }
            }
        }
    }

    // 합 구하기
    static int sum(int[] arr){
        int result = 0;
        for(int i = 0; i<arr.length-1; i++){
            result += Math.abs(arr[i] - arr[i+1]);
        }

        return result;
    }
}
