package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16987 {
    static boolean[] check; // 확인 변수

    static int max = Integer.MIN_VALUE;
    static int[][] eggs; // 계란 능력치
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        eggs = new int[N][2];
        check = new boolean[N];

        for(int i = 0; i<N; i++){
            String[] vals = bf.readLine().split(" ");

            eggs[i][0] = Integer.parseInt(vals[0]);
            eggs[i][1] = Integer.parseInt(vals[1]);
        }

        //check[0] = true;
        rec_func(0,0);

        System.out.println(max);
    }

    static void rec_func(int idx, int value){
        if(idx == N-1){
            max = Math.max(value,max);
            return;
        }else{
            if(eggs[idx][0] <= 0){
                rec_func(idx+1, value);
                return;
            }
            for(int i = 1; i<N; i++){
                if(check[i] == false && eggs[i][0] > 0){
                    check[i] = true;

                    eggs[i][0] -= eggs[idx][1];
                    eggs[idx][0] -= eggs[i][1];

                    if(eggs[i][0] <= 0) value++;
                    if(eggs[idx][0] <= 0) value++;

                    rec_func(idx+1, value);

                    if(eggs[i][0] <= 0) value--;
                    if(eggs[idx][0] <= 0) value--;

                    eggs[i][0] += eggs[idx][1];
                    eggs[idx][0] += eggs[i][1];

                    check[i] = false;
                }
            }
        }
    }
}
