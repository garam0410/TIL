package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q1920 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String[] tmp = bf.readLine().split(" ");

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<N; i++){
            map.put(Integer.parseInt(tmp[i]),1);
        }

        int M = Integer.parseInt(bf.readLine());

        tmp = bf.readLine().split(" ");

        for(int i = 0; i<M; i++){
            if(map.get(Integer.parseInt(tmp[i])) != null)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
