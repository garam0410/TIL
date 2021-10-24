package com.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14502 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] maps;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] vals = bf.readLine().split(" ");

        N = Integer.parseInt(vals[0]);
        M = Integer.parseInt(vals[1]);

        maps = new int[N][M];

        // 지도 만들기
        for(int i = 0; i<N; i++){
            vals = bf.readLine().split(" ");

            for(int j = 0; j<M; j++){
                maps[i][j] = Integer.parseInt(vals[j]);
            }
        }

        rec_func(0,0, 0);
    }

    // 1을 새울 재귀 함수
    static void rec_func(int x, int y, int cnt){
        if(x<=-1 || y<=-1 || x>=N || y >= M){
            return;
        }
        if(cnt==3)
            deathZone();
        else{
            if(maps[x][y] == 0){
                maps[x][y] = 1;
                rec_func(x,y,cnt+1);
                maps[x][y] = 0;
            }else{
                for(int i = 0; i<4; i++){
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    rec_func(cx,cy,cnt);
                }
            }
        }
    }

    // 바이러스를 퍼트릴 재귀 함수
    static void deathZone(){

    }

    //안전 구역을 세는 함수
    static void cntSafeArea(){

    }
}
