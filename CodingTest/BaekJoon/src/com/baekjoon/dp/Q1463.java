package com.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q1463 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());

        ArrayList<Integer> type = new ArrayList<Integer>();

        if(num % 2 == 0){
            type.add(Mod2(num));
            result = 0;
        }

        if(num % 3 == 0){
            type.add(Mod3(num));
            result = 0;
        }
        if(num % 6 == 0){
            type.add(Mod6(num));
            result = 0;
        }
        type.add(Sub1(num));

        Collections.sort(type);
        System.out.println(Arrays.toString(type.toArray()));
        System.out.println(type.get(0));
    }

    public static int Check(int num){
        if(num % 2 == 0){
            return Mod2(num);
        }

        if(num % 3 == 0){
            return Mod3(num);
        }

        if(num % 6 == 0){
            return Mod6(num);
        }

        return Sub1(num);
    }

    public static int Mod6(int num){
        if(num == 1) return result;
        num /= 6;
        result +=1;
        return Check(num);
    }

    public static int Mod3(int num){
        if(num == 1) return result;
        num /= 3;
        result +=1;
        return Check(num);
    }

    public static int Mod2(int num){
        if(num == 1) return result;
        num /= 2;
        result +=1;
        return Check(num);
    }

    public static int Sub1(int num){
        if(num == 1) return result;
        num -= 1;
        result +=1;
        return Check(num);
    }
}
