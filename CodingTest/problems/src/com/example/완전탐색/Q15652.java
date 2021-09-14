package com.example.완전탐색;

import java.util.Scanner;

// N개 중 중복을 허용해서 M개를 고르기
public class Q15652 {
    static int N, M;
    static int[] selected, used;
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k){
        if(k == M+1){ // 다 골랐다
            for(int i = 1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }
        else{
            int start = selected[k-1];
            if(start == 0) start = 1;
            for(int num = start; num <= N; num++){
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

