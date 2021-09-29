package com.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 근묵자흑 {
    public static void main(String[] args) throws Exception {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int[] nums = new int[N];

        for(int i = 0; i<N-1; i=i+K-1){
            answer++;
        }
        System.out.println(answer);
    }
}
