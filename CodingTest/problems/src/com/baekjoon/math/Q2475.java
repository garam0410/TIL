package com.baekjoon.math;

import java.util.Scanner;

public class Q2475 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        String[] val = sc.nextLine().split(" ");

        for(int i = 0; i<val.length; i++){
            int num = Integer.parseInt(val[i]);
            answer += num * num;
        }

        System.out.println(answer % 10);
    }
}
