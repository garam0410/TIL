package com.baekjoon.implementation;

import java.util.Scanner;

public class Q2441 {
    public static void main(String[] args){
        int num = new Scanner(System.in).nextInt();

        String rs = "";

        for(int i = 0; i<num; i++){
            rs += "*";
        }

        for(int i = 0; i<num; i++){
            System.out.printf("%"+num+"s",rs);
            rs = rs.substring(0,rs.length()-1);
            if(i != num-1)
                System.out.println();
        }
    }
}
