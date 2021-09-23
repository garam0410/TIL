package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16922 {
    static int[] roman;
    static int N;
    static boolean[] check = new boolean[1001];
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        roman = new int[]{1,5,10,50};

        rec_func(0, 0, 0);

        System.out.println(answer);
    }

    static void rec_func(int cnt, int value, int idx){
        if(cnt == N){
            if(!check[value]){
                check[value] = true;
                answer++;
            }
        }
        else{
            for(int i = idx; i<4; i++){
                rec_func(cnt+1,value + roman[i],i);
            }
        }
    }
}
