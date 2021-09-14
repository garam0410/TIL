package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9625 {

    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try{
            int num = Integer.parseInt(bf.readLine());

            int a_cnt = 0;
            int b_cnt = 1;

            for(int i = 0; i<num; i++){
                int sum = a_cnt + b_cnt;

                if(i!=0)
                    a_cnt = b_cnt;

                b_cnt = sum;
            }

            System.out.println(a_cnt + " " + b_cnt);
        }catch(IOException e){}
    }
}
