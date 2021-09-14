package com.baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Q10817 {
    public static void main(String[] args){
        String[] num = new Scanner(System.in).nextLine().split(" ");

        int[] rsNum = new int[3];

        for(int i = 0; i<num.length;i++)
            rsNum[i] = Integer.parseInt(num[i]);

        Arrays.sort(rsNum);

        System.out.println(rsNum[1]);
    }
}
