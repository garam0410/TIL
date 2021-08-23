package com.baekjoon.implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10870 {
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();

        arrayList.add(0);
        arrayList.add(1);

        for(int i = 0; i<cnt - 1; i++){
            arrayList.add(arrayList.get(i) + arrayList.get(i+1));
        }

        System.out.println(arrayList.get(cnt));
    }
}
