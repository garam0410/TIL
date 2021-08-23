package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        int[] result = new int[cnt];

        String[] nums = bf.readLine().split(" ");

        for(int i = 0; i<nums.length; i++)
            result[i] = Integer.parseInt(nums[i]);

        Arrays.sort(result);

        System.out.printf(result[0] +" " + result[result.length-1]);
    }
}
