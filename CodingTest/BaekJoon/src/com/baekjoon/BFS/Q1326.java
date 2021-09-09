package com.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1326 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 징검다리 갯수
        int N = Integer.parseInt(bf.readLine());

        String[] val = bf.readLine().split(" ");

        // 징검다리 배수 번호
        int[] rock = new int[val.length];

        for(int i = 0; i<val.length; i++)
            rock[i] = Integer.parseInt(val[i]);

        String[] nums = bf.readLine().split(" ");

        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);

        System.out.println(bfs(rock,a-1,b-1,cnt));
    }

    static int bfs(int[] rock, int a, int b, int cnt){
        // 남은 칸수
        int num = b - a;
        if(num == 0) return cnt;

        if(num / rock[a] >= 0){
            for(int i = num/rock[a]; i>0; i--){
                if(bfs(rock,a+rock[a]*(i),b,cnt+1) < 0)
                    continue;
                else
                    return bfs(rock,a+rock[a]*(i),b,cnt+1);
            }
        }
        return -1;
    }
}
