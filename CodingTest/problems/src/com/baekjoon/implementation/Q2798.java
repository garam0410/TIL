package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q2798 {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int N, M;
        String[] val = bf.readLine().split(" ");
        N = Integer.parseInt(val[0]); // 갯수
        M = Integer.parseInt(val[1]); // 부른 값

        val = bf.readLine().split(" ");

        int[] card = new int[N]; // 카드

        for(int i = 0; i<N; i++)
            card[i] = Integer.parseInt(val[i]);

        for(int i = 0; i<N-2; i++){
            recur(i,N,card, answer + card[i], 1);
        }

        System.out.println(Arrays.toString(arr.toArray()));

        answer = M;
        int rs = 0;

        Collections.sort(arr, Collections.reverseOrder());
        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i) <= answer){
                rs = arr.get(i);
                break;
            }
        }
        System.out.println(rs);
    }

    static int recur(int i, int n, int[] card, int answer, int depth){
        if(depth == 3){
            arr.add(answer);
            return answer;
        }
        for(int cnt = i+1; cnt<n; cnt++){
            recur(cnt,n,card,answer+card[cnt], depth+1);
        }
        return 0;
    }
}
