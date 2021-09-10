package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        System.out.println(result(N));
    }

    static int result(int n){
        int answer = n;

        for(int i = 1; i<=n; i++){
            int num = n - i;

            String[] value = String.valueOf(num).split("");

            for(int j = 0;j<value.length; j++){
                int plus = Integer.parseInt(value[j]);
                num += plus;
            }
            if(num == n)
                answer = Math.min(answer,n - i);
        }

        if(answer == n)
            return 0;

        return answer;
    }
}
