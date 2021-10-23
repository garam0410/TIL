package com.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1662 {

    static String[] s;

    static int answer = 0;

    static int idx = 0;

    public static void main(String[] args) throws IOException {
        // Q라는 문자열이 K번 반복
        // K(Q)
        // K는 한자리 정수
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        s = bf.readLine().split("");

        System.out.println(rec_func());
    }

    static int rec_func(){
        int ans = 0;
        if(idx == s.length)
            return 1;
        else{
            for(int i = idx; i<s.length; i++){
                if(s[i].equals("(")){
                    ans--;
                    int val = Integer.parseInt(s[i-1]);
                    idx++;
                    ans = ans + val * rec_func();
                    i = idx-1;
                }else if(s[i].equals(")")){
                    idx++;
                    return ans;
                }else{
                    idx++;
                    ans++;
                }
            }
        }
        return ans;
    }
}
