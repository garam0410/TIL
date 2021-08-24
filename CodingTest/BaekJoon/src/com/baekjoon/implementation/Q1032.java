package com.baekjoon.implementation;

import java.util.Scanner;

public class Q1032 {
    public static void main(String[] args){
        // 인덱스 별로 비교해서 다르면, 그 뒤는 ?로 수정
        String result = "";

        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();

        String[] files = new String[cnt];

        for(int i = 0; i<cnt; i++){

            files[i] =sc.next();
        }

        for(int i = 0; i<files[0].length(); i++){

            char tmp = ' ';
            int j;

            for(j = 0; j< files.length; j++){
                if(j == 0) {
                    tmp = files[j].charAt(i);
                }else{
                    if(tmp == files[j].charAt(i)){
                        continue;
                    }
                    else{
                        break;
                    }
                }
            }

            if(j!=files.length){
                result += "?";
            }else{
                result += files[0].charAt(i);
            }
        }

        System.out.printf(result);
    }
}
