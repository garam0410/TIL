package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2460 {
    public static void main(String[] arsgs) throws IOException {
        int max = 0;
        int current = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<10; i++){
            String[] nums = bf.readLine().split(" ");
            current = current - Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);

            if(current > max)
                max = current;
        }

        System.out.println(max);
    }
}
