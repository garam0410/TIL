package com.groom;

import java.io.*;
import java.util.*;
class Main {
    static int n, m, k;
    static int[][] matrix;
    static int max = Integer.MIN_VALUE;

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] vals = br.readLine().split(" ");

        n = Integer.parseInt(vals[0]);
        m = Integer.parseInt(vals[1]);
        k = Integer.parseInt(vals[2]);

        matrix = new int[n][m];

        for(int i = 0; i<n; i++){
            vals = br.readLine().split(" ");

            for(int j = 0; j<m; j++)
                matrix[i][j] = Integer.parseInt(vals[j]);
        }

        rec_func(0, 0);

        System.out.println(max);
    }

    static void rec_func(int cnt, int depth){
        if(depth==n){
            if(cnt != k)
                return;
            else{
                int value = 0;
                Stack<Integer> tmp = (Stack<Integer>) stack.clone();
                for(int i = 0; i<n; i++){
                    value += matrix[i][m - tmp.pop()];
                }

                max = Math.max(value,max);
            }
        }else{
            for(int i = 0; i<m; i++){
                stack.push(i+1);
                rec_func(cnt + i+1, depth+1);
                stack.pop();
            }
        }
    }
}