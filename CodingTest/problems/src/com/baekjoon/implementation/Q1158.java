package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr = new ArrayList<>();

        ArrayList<Integer> answer = new ArrayList<>();

        String[] vals = bf.readLine().split(" ");

        int N = Integer.parseInt(vals[0]);
        int K = Integer.parseInt(vals[1]);

        for(int i = 1; i<N+1; i++)
            arr.add(i);

        int idx = K-1;

        while(!arr.isEmpty()){
            answer.add(arr.get(idx));
            System.out.println(arr.get(idx));
            arr.remove(idx);
            
        }

        System.out.println(Arrays.toString(answer.toArray()));
    }
}
