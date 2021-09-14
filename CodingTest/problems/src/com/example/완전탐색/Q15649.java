package com.example.완전탐색;

import java.util.Scanner;

// N개 중 중복없이 M개를 순서있게 나열하기
public class Q15649 {
    static int N, M;
    static int[] selected, used;
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k){
        if(k == M+1){ // 다 골랐다
            for(int i = 1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }
        else{
            // 1~N 까지를 K번 원소로 한 번씩 정하고,
            // 매번 k+1 번 부터 M번 원소로 재귀호출 하기
            for(int num = 1; num <= N; num++){
                //다음에 들어갈 숫자가 사용되고있는지 검사
                if(used[num] == 1) continue;

                selected[k] = num;
                used[num] = 1;

                rec_func(k+1);
                selected[k] = 0;
                used[num] = 0;
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

