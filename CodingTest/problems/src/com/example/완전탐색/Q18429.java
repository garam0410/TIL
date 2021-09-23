package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18429 {

    static int N, K;
    static int[] kit;
    static boolean[] check;
    static int answer = 0;
    static int kg = 500;

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] val = bf.readLine().split(" ");

        N = Integer.parseInt(val[0]);
        K = Integer.parseInt(val[1]);

        kit = new int[N];
        check = new boolean[N];

        val = bf.readLine().split(" ");

        for(int i = 0 ;i<N; i++)
            kit[i] = Integer.parseInt(val[i]);

        rec_func(0, kg);

        System.out.println(answer);
    }

    static void rec_func(int cnt, int value) {
        if(cnt == N){
            answer++;
        }else{
            for(int i = 0; i<N; i++){
                if(check[i]==false){
                    if(value+kit[i]-K>=500){
                        check[i] = true;
                        rec_func(cnt+1, value+kit[i]-K);
                        check[i] = false;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
    }
}
