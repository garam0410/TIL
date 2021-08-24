package com.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());

        for(int i = 0; i<cnt; i++){
            int n = Integer.parseInt(bf.readLine());
            dp = new int[n+1];
            System.out.println(progress(n));
        }
    }

    static int progress(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;

        if(dp[n] > 0)
            return dp[n];

        dp[n] = progress(n-1) + progress(n-2) + progress(n-3);

        return dp[n];
    }
}
