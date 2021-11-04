package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Q19699 {
    static boolean[] check;
    static int[] cows;
    static int M, N;
    static boolean[] prime;
    static int sum = 0;
    static HashMap<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] vals = bf.readLine().split(" ");

        N = Integer.parseInt(vals[0]);
        M = Integer.parseInt(vals[1]);

        cows = new int[N];
        check = new boolean[N];

        vals = bf.readLine().split(" ");

        for(int i = 0; i<N; i++){
           sum += Integer.parseInt(vals[i]);
           cows[i] = Integer.parseInt(vals[i]);
        }

        setPrime();

        rec_func(0, 0);

        if(result.size() == 0) System.out.println(-1);
        else{
            ArrayList<Integer> arr = new ArrayList<>();

            for(int key : result.keySet())
                arr.add(key);

            Collections.sort(arr);

            for(int i = 0; i<arr.size(); i++)
                sb.append(arr.get(i) + " ");

            System.out.println(sb);
        }
    }

    // 소수 판별기
    static void setPrime(){
        prime = new boolean[sum+1];
        prime[1] = true;

        for(int i = 2; i<sum+1; i++){
            if(prime[i] == false){
                for(int j = 2; j<sum+1; j++){
                    try{
                        prime[i*j] = true;
                    }catch(Exception e){
                        break;
                    }
                }
            }else if (prime[i] == true) continue;
        }
    }

    // 재귀 함수
    static void rec_func(int value, int cnt){
        if(cnt == M){
            if(prime[value] == false) result.put(value,value);
        }else{
            for(int i = 0; i<N; i++){
                if(check[i] == false){
                    check[i] = true;
                    rec_func(value + cows[i], cnt + 1);
                    check[i] = false;
                }
            }
        }
    }
}
