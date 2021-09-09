package com.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16173 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[][] graph = new int[N][N];

        for(int i = 0; i<N; i++){
            String[] val = bf.readLine().split(" ");
            for(int j = 0; j<N;j++){
                graph[i][j] = Integer.parseInt(val[j]);
            }
        }
        // 출발 점
        int x = 0, y = 0;

        if(bfs(graph,x,y,N))
            System.out.println("HaruHaru");
        else
            System.out.println("Hing");
    }
    static boolean bfs(int[][] graph, int x, int y, int N){
        if(x>=N || y >= N) return false;
        if(graph[x][y]==-1) return true;
        if(graph[x][y]==0) return false;

        if(bfs(graph,x,y+graph[x][y],N))
            return true;
        if(bfs(graph,x+graph[x][y],y,N))
            return true;

        return false;
    }
}
