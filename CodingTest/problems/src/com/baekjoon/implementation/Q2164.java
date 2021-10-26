package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<N; i++){
            queue.add(i+1);
        }

        while(queue.size() != 1){
            queue.poll();
            if(queue.size()== 1) break;
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
