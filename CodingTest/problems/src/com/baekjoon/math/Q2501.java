package com.baekjoon.math;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2501 {
    public static void main(String[] args){
        String[] num = new Scanner(System.in).nextLine().split(" ");

        ArrayList<Integer> result = new ArrayList<Integer>();


        for(int i = 1; i<=Integer.parseInt(num[0]); i++){
            if(Integer.parseInt(num[0]) % i == 0){
                result.add(i);
            }
        }

        try{
            System.out.println(result.get(Integer.parseInt(num[1])-1));
        }catch(Exception e){
            System.out.println(0);
        }
    }
}
