package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2529 {

    static int k;
    static String[] val;
    static boolean[] check = new boolean[11];

    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;

    static String a = "";
    static String b = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(bf.readLine());

        val = bf.readLine().split(" ");
        for(int i = 0; i<10; i++){
            check[i] = true;
            rec_func(0, String.valueOf(i), 0);
            check[i] = false;
        }

        System.out.println(a);
        System.out.println(b);
    }

    static void rec_func(int cnt, String value, int pos){
        if(cnt == k){
            if(min>Long.parseLong(value))
                b = value; min = Long.parseLong(value);
            if(max<Long.parseLong(value))
                a = value; max = Long.parseLong(value);
        }else{
            // 부등호에 맞는 숫자를 대입
            for(int i = pos; i<k; i++){
                for(int j = 0; j<10; j++){
                    String tmp = String.valueOf(value.charAt(value.length()-1)); // 마지막 항
                    if(val[i].equals("<") && Integer.parseInt(tmp) < j && check[j] == false){
                        check[j] = true;
                        rec_func(cnt+1,value+j,i+1);
                        check[j] = false;
                    }else if(val[i].equals(">") && Integer.parseInt(tmp) > j && check[j] == false){
                        check[j] = true;
                        rec_func(cnt+1,value+j,i+1);
                        check[j] = false;
                    }
                }
            }
        }
    }
}
