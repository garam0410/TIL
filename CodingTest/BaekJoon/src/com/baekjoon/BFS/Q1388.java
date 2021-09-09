package com.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] size = bf.readLine().split(" ");

        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        String[][] graph = new String[N][M];

        for(int i = 0; i<N; i++){
            String[] val = bf.readLine().split("");
            for(int j = 0; j<M; j++){
                graph[i][j] = val[j];
            }
        }

        int horizental = 0;
        int vercital = 0;

        String before = "";

        for(int i = 0; i<N; i++){
            before = "|";
            for(int j = 0; j<M; j++){
                if(graph[i][j].equals("-") && before.equals("|")){
                    before = "-";
                    horizental +=1;
                }else if(graph[i][j].equals("-"))
                    continue;
                else if(graph[i][j].equals("|"))
                    before = "|";
            }
        }

        for(int i = 0; i<M; i++){
            before = "-";
            for(int j = 0; j<N; j++){
                if(graph[j][i].equals("|") && before.equals("-")){
                    before = "|";
                    vercital +=1;
                }else if(graph[j][i].equals("|"))
                    continue;
                else if(graph[j][i].equals("-"))
                    before = "-";
            }
        }

        System.out.println(horizental + vercital);
    }
}
