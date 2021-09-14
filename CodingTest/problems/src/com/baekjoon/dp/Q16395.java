package com.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16395 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] num = bf.readLine().split(" ");

        dp = new int[Integer.parseInt(num[0])+1][Integer.parseInt(num[0])+1];

        System.out.println(recur(Integer.parseInt(num[0]),Integer.parseInt(num[1])));
    }

    static int recur(int n, int k){
        if(n==1) return 1;
        if(n==2) return 1;
        if(k==1 || k==n) return 1;

        dp[n][k] = recur(n-1, k-1) + recur(n-1, k);
        return dp[n][k];
    }
}
