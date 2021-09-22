package com.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 완전수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for(int i = A; i<=B; i++){

            int sum = 0;

            for(int j = 1; j<i; j++){
                if(i % j == 0)
                    sum += j;
            }

            if(sum == i)
                sb.append(sum+" ");
        }

        System.out.println(sb.toString());
    }
}
