package com.baekjoon.implementation;

import java.util.Scanner;

public class Q11050 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] val = sc.nextLine().split(" ");
        int N = Integer.parseInt(val[0]);
        int K = Integer.parseInt(val[1]);


        System.out.println(factorial(N) / (factorial(K)*factorial(N-K)));


    }

    static int factorial(int n){
        if(n==1) return 1;
        if(n==0) return 1;
        return n * factorial(n-1);
    }
}
