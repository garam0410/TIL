package com.baekjoon.implementation;

import java.util.Scanner;

public class Q10872 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int value = scanner.nextInt();
        long val = 1;
        for(int i = value; i>0; i--){
            val *= i;
        }
        System.out.println(val);
    }
}
