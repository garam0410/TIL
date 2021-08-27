package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        int cnt = s.length() / 10;

        for(int i = 0; i<=cnt; i++){
            try{

                if(i==0)
                    System.out.println(s.substring(i,10));
                else
                    System.out.println(s.substring(i*10,i*10+10));

            }catch(Exception e){
                System.out.println(s.substring(i*10));
            }

        }
    }
}
