package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = bf.readLine().split(" ");

        int num1 = Integer.valueOf(nums[0], 2);
        int num2 = Integer.valueOf(nums[1], 2);

        System.out.println(Integer.toBinaryString(num1 + num2));
    }
}
