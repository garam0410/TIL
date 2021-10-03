package com.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Q20291 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(bf.readLine());

        ArrayList<String> arr = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String[] tmp = bf.readLine().split("[.]");

            if(map.get(tmp[1])!=null){
                map.put(tmp[1],map.get(tmp[1])+1);
            }else{
                map.put(tmp[1], 1);
                arr.add(tmp[1]);
            }
        }

        Collections.sort(arr);

        for(int i= 0; i<arr.size(); i++)
            System.out.println(arr.get(i) + " " + map.get(arr.get(i)));

    }
}
