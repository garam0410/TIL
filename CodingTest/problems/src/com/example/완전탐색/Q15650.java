package com.example.완전탐색;

import java.util.Scanner;

// N개 중 중복 없이 M개를 고르기
public class Q15650 {
    static int N, M;
    static int[] selected, used;
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k){
        if(k == M+1){ // 다 골랐다
            for(int i = 1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }
        else{
            for(int num = selected[k-1]+1; num <= N; num++){
                //k번째에 num이 올 수 있으면
                selected[k] = num;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] val = sc.nextLine().split(" ");
        N = Integer.parseInt(val[0]);
        M = Integer.parseInt(val[1]);

        selected = new int[M+1];
        used = new int[N+1];
        rec_func(1);
        System.out.println(sb.toString());
    }
}


