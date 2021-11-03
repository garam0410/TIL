package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q21735 {
    static int N, M;
    static int[] snows;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] vals = bf.readLine().split(" ");

        N = Integer.parseInt(vals[0]);
        M = Integer.parseInt(vals[1]);

        snows = new int[N];

        vals = bf.readLine().split(" ");

        for(int i = 0; i<N; i++)
            snows[i] = Integer.parseInt(vals[i]);

        // 시작 위치, 시간, 눈덩이 크기
        rec_func(0,0,1);

        System.out.println(max);
    }

    static void rec_func(int idx, int time, int size){
        if(time > M) return;

        if(time <= M){
            max = Math.max(size, max);
        }
            if(!(idx+1 >= N))
                // 1칸 이동
                rec_func(idx + 1, time + 1, size + snows[idx+1]);

            if(!(idx+2 >= N))
                // 2칸 이동
                rec_func(idx + 2, time + 1, size/2 + snows[idx+2]);

    }
}