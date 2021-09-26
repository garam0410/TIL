package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1987 {
    static boolean[] check = new boolean[26]; // 알파벳을 사용했는지 확인할 배열

    static int R;
    static int C;
    static char[][] alpha;

    // 좌표 이동
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int max = Integer.MIN_VALUE;

    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
//        System.out.println((int) 'A');
//        System.out.println((int) 'Z');

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");

        R = Integer.parseInt(tmp[0]);
        C = Integer.parseInt(tmp[1]);

        alpha = new char[R][C];

        for(int i = 0; i<R; i++){
            String temp = bf.readLine();

            for(int j = 0; j<C; j++){
                alpha[i][j] = temp.charAt(j);
            }
        }

        check[alpha[0][0]-65] = true;
        rec_func(0,0,1);

        System.out.println(max);
    }

    // x좌표, y좌표
    static void rec_func(int x, int y, int val){
        if(x<=-1 || y<=-1 || x>=R || y>=C)
            return;

        for(int i = 0; i<4; i++){

            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx <0 || cy<0|| cx>=R || cy>=C) continue;

            if(check[alpha[cx][cy]-65] == false){
                check[alpha[cx][cy]-65] = true;
                rec_func(cx,cy,val+1);
                check[alpha[cx][cy]-65] = false;
            }
            else{
                max = Math.max(max,val);
            }
        }
    }
}
