package com.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder(input);

        System.out.println(sb.reverse().toString());
    }
}
