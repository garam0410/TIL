package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q1018 {
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] val = bf.readLine().split(" ");
        int N = Integer.parseInt(val[0]);
        int M = Integer.parseInt(val[1]);

        String[][] chess = new String[N][M];

        // 배열에 모두 넣기
        for(int i = 0; i<N; i++){
            String[] tmp = bf.readLine().split("");
            for(int j = 0; j<M; j++)
                chess[i][j] = tmp[j];
        }

        for(int i = 0; i<=N-8; i++){
            for(int j = 0; j<=M-8; j++){
                result.add(count(i,j,chess));
            }
        }

        Collections.sort(result);
        if(result.size()==0)
            System.out.println(0);
        else
            System.out.println(result.get(0));

        System.out.println(Arrays.toString(result.toArray()));

        for(int i = 0; i<chess.length; i++){
            System.out.println(Arrays.toString(chess[i]));
        }
    }

    static int count(int a, int b, String[][] chess){
        String start = "";
        int cnt = 64;

        String[] arr = {"W","B"};

        for(int type = 0; type<arr.length; type++){
            start = arr[type];
            int test = 0;
            for(int i = a; i<a+8; i++){
                for(int j = b; j<b+8; j++){
                    if(!chess[i][j].equals(start)){
                        test+=1;
                        start = change(start);
                    }else{
                        start = change(start);
                    }
                }
                start = change(start);
            }
            if(type == 0)
                cnt = test;
            else
                cnt = Math.min(cnt,test);
        }
        return cnt;
    }

    static String change(String peace){
        if(peace.equals("W"))
            return "B";
        else
            return "W";
    }
}
