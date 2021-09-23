package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q14889 {

    static int min = Integer.MAX_VALUE;

    static int A = 0;
    static int B = 0;

    static int N;
    static int[][] score;
    static boolean[] group;

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        score = new int[N][N];

        cnt = N/2;
        group = new boolean[N];

        for(int i = 0; i<N; i++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 0; j<N; j++){
                score[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        rec_func(0, 0);

        System.out.println(min);
    }

    // 쌍을 만드는 함수
    static void rec_func(int count, int idx){
        if(count == cnt){

            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> link = new ArrayList<>();

            for(int i = 0; i<group.length; i++){
                if(group[i]==true){
                    start.add(i);
                }else{
                    link.add(i);
                }
            }

            min = Math.min(min,calculator(start, link));
            A = 0;
            B = 0;
        }
        else{
            for(int i = idx; i<group.length; i++){
                if(group[i] == false){
                    group[i] = true;
                    rec_func(count+1, i+1);
                    group[i] = false;
                }
            }
        }
    }

    // 점수를 계산해서 두 팀의 차이를 계산하는 함수
    static int calculator(ArrayList<Integer> start, ArrayList<Integer> link){
        for(int i = 0; i<cnt; i++){
            for(int j = i+1; j<cnt; j++){
                A += score[start.get(i)][start.get(j)] + score[start.get(j)][start.get(i)];
                B += score[link.get(i)][link.get(j)] + score[link.get(j)][link.get(i)];
            }
        }
        return Math.abs(A-B);
    }
}
