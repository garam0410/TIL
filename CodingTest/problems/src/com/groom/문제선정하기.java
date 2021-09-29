package com.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 문제선정하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();

        String[] prob = br.readLine().split(" ");

        for(int i = 0; i<input; i++)
            map.put(prob[i],prob[i]);

        if(map.size() >=3)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
