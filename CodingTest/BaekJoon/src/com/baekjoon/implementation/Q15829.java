package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(bf.readLine());
        String s = bf.readLine();

        long answer = 0;
        // a = 96

        for(int i = 0; i<s.length(); i++){
            answer += ((int)s.charAt(i)-96)  * Math.pow(31,i);
        }
        System.out.println(answer);
    }
}
