package com.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 약수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int i = 1; i<=num; i++){
            if(num % i == 0)
                sum += i;
        }

        System.out.println(sum);
    }
}
