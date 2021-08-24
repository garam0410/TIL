package com.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long cnt = Integer.parseInt(bf.readLine());

        long a = 0;
        long b = 1;
        long c = 0;

        for(int i = 1; i<cnt; i++){
            c = a + b;
            a = b;
            b = c;
        }

        System.out.println(b*4 + a*2);
    }
}
