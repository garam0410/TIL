package com.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());

        dp = new int[num+1];
        int result = recur(num);
        System.out.println(result);
    }

    static int recur(int n){
        if(n==1) return 0;
        if(dp[n] > 0) return dp[n];

        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MAX_VALUE;
        int r3 = Integer.MAX_VALUE;

        if(n % 3 == 0)
            r1 = recur(n/3) + 1;
        if(n % 2 == 0)
            r2 = recur(n/2) + 1;

        r3 = recur(n-1) + 1;

        return dp[n] = Math.min(r1, Math.min(r2, r3));
    }
}
