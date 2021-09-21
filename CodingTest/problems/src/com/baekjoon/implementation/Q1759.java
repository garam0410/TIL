package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1759 {
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] val = bf.readLine().split(" ");

        int L = Integer.parseInt(val[0]);
        int C = Integer.parseInt(val[1]);

        String[] alpha = bf.readLine().split(" ");

        check = new boolean[C];

        Arrays.sort(alpha);

        rec_func(L,C,0, alpha, "", 0);

    }

    static void rec_func(int L, int C, int cnt, String[] alpha, String value, int idx){
        if(cnt == L){
            if(checkCnt(value)){
                System.out.println(value);
            }
        }
        else{
            for(int i = idx; i<C; i++){
                if(check[i] == false){
                    check[i] = true;
                    rec_func(L,C,cnt+1, alpha, value+alpha[i],i+1);
                    check[i] = false;
                }
            }
        }
    }

    static boolean checkCnt(String value){

        int a = 0;
        int b = 0;

        for(int i = 0; i<value.length(); i++){
            if(value.charAt(i) == 'a' || value.charAt(i)=='e' || value.charAt(i)=='i'
                    || value.charAt(i)=='o' || value.charAt(i)=='u')
                a++;
            else
                b++;
        }

        if(a >=1 && b>=2)
            return true;
        else
            return false;
    }
}
