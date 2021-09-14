package com.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15881 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());

        String s = bf.readLine();

        s = s.replaceAll("pPAp", "0");

        int result = 0;

        for(int i = 0;i<s.length(); i++)
            if(s.charAt(i) == '0')
                result +=1;

        System.out.println(result);
    }
}
