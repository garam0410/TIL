package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1009 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try{
            int cnt = Integer.parseInt(bf.readLine());

            for(int i = 0; i<cnt; i++){
                String[] ab = bf.readLine().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);

                int result = 1;

                for(int j = 1; j<=b; j++){
                    result *= a;
                    result %= 10;
                }
                if(result == 0)
                    System.out.println(10);
                else
                    System.out.println(result);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
