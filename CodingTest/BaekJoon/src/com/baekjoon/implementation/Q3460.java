package com.baekjoon.implementation;

import java.util.Scanner;

public class Q3460 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();

        for(int i = 0; i<cnt; i++){
            StringBuffer binary = new StringBuffer(Integer.toBinaryString(sc.nextInt()));
            binary = binary.reverse();
            String result = "";

            for(int j = 0; j<binary.length(); j++){
                if(binary.charAt(j) == '1'){
                    result += j+" ";
                }
            }
            System.out.println(result);
        }
    }
}
