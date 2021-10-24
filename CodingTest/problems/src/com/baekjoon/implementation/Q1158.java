package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();

        String[] vals = bf.readLine().split(" ");

        int N = Integer.parseInt(vals[0]);
        int K = Integer.parseInt(vals[1]);

        for(int i = 1; i<N+1; i++)
            queue.add(i);

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        while(!queue.isEmpty()){
            for(int i = 0; i<K-1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
