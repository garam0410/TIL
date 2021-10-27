package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10971 {
    static int n;
    static int[][] costs;
    static boolean[] check;

    static int result = Integer.MAX_VALUE;
    static int initIdx = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        costs = new int[n][n];

        for(int i = 0; i<n; i++){
            String[] vals = bf.readLine().split(" ");

            for(int j = 0; j<n; j++)
                costs[i][j] = Integer.parseInt(vals[j]);
        }

        for(int i = 0; i<n; i++){
            check = new boolean[n];
            check[i] = true;
            initIdx = i;
            rec_func(i,1, 0);
        }

        System.out.println(result);
    }

    static void rec_func(int x, int cnt, int value){
        if(cnt == n){
            if(costs[x][initIdx] != 0){
                value += costs[x][initIdx];
                result = Math.min(result,value);
            }
            return;
        }else{
            for(int i = 0; i<n; i++){
                if(check[i] == false && costs[x][i]!= 0){
                    check[i] = true;
                    rec_func(i,cnt+1,value + costs[x][i]);
                    check[i] = false;
                }
            }
        }
    }
}
