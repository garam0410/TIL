package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15663 {
    static boolean[] check;
    static ArrayList<String> arr = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static PriorityQueue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] val = bf.readLine().split(" ");

        int N = Integer.parseInt(val[0]);
        int M = Integer.parseInt(val[1]);

        val = bf.readLine().split(" ");

        int[] nums = new int[val.length];

        for(int i = 0; i<nums.length; i++)
            nums[i] = Integer.parseInt(val[i]);

        check = new boolean[N];

        Arrays.sort(nums);

        rec_func(N,M,nums,0,0, "");
    }

    static int t = 0;

    static void rec_func(int N, int M, int[] nums, int cnt, int idx, String value){
        if(cnt == M){
            String tmp = value.substring(0,value.length()-1);
            if(!map.containsKey(tmp)){
                map.put(tmp,t);
                t++;
                System.out.println(tmp);
            }
        }else{
            for(int i = 0; i<N; i++){
                if(check[i] == false){
                    check[i] = true;
                    rec_func(N,M,nums,cnt+1,idx+1, value+nums[i] + " ");
                    check[i] = false;
                }
            }
        }
    }
}
