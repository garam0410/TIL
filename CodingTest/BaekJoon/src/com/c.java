package com;

import java.util.ArrayList;
import java.util.Arrays;

public class c {
    public static void main(String[] args){
        System.out.println(new Solution().solution(new int[][]{{1,1,1},{1,1,1},{1,1,1}}, new int[]{1, 0}, new int[]{1,2}));
    }
    static class Solution {
        // 좌표 이동
        // 상하좌우
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};

//     // 결과를 저장할 리스트
         static ArrayList<Integer> result = new ArrayList<>();

        public int solution(int[][] board, int[] aloc, int[] bloc) {
            int answer = -1;
            //board의 크기만큼 boolean 만든다
            boolean[][] graph = new boolean[board.length][board[0].length];

            int ax = aloc[0];
            int ay = aloc[1];
            int bx = bloc[0];
            int by = bloc[1];
            boolean aMove = false;

            answer = func(graph,ax,ay,bx,by,answer,aMove);
            System.out.println(Arrays.toString(result.toArray()));

            return answer;
        }

        static int func(boolean[][] graph, int ax, int ay, int bx, int by, int answer, boolean aMove){
            if(ax<=-1 || bx<=-1 || ay<=-1 || by<=-1 || ax>=graph.length || bx>= graph.length ||ay>=graph.length || by>=graph.length) return 0;
            // 방문한 칸이라면?
            if(graph[bx][by] == true){
                for(int i = 0; i<graph.length; i++){
                    for(int j = 0; j<graph[i].length; j++){
                        if(graph[i][j]==false){
                            System.out.println("실패");
                            viewGraph(graph);
                            return 0;
                        }

                    }
                }
                System.out.println("최적");
                System.out.println(answer);
                viewGraph(graph);
                result.add(answer);
                return 0;
            }
            if(aMove==false){
                //a먼저 움직이고 b움직이기
                for(int i = 0 ;i<4; i++){
                    graph[ax][ay] = true;
                    int tx = ax + dx[i];
                    int ty = ay + dy[i];
                    func(graph,tx,ty,bx,by,answer+1,true);
                }
            }else if(aMove==true){
                for(int i = 0 ;i<4; i++){
                    graph[bx][by] = true;
                    int tx = bx + dx[i];
                    int ty = by + dy[i];
                    func(graph,ax,ay,tx,ty,answer+1,false);
                }
            }
            return 0;
        }
    }

    static void viewGraph(boolean[][] graph){
        for(int i = 0; i<graph.length; i++){
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}
