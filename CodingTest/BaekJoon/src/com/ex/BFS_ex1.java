package com.ex;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_ex1 {
    static int n = 5;
    static int m = 6;
    static int[][] graph;

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args){
        graph = new int[][]{{1, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};

        System.out.println(bfs(0,0));
    }

    static int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        // 항목 Queue에 넣기
        queue.offer(new Node(x,y));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            x = node.x;
            y = node.y;

            // 현재 위치에서 4가지 방향 모두 확인

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //공간을 벗어난 경우
                if(nx<0 || ny < 0 || nx >= n || ny >= m) continue;

                // 벽인 경우에는 무시
                if(graph[nx][ny] == 0) continue;

                // 해당 노드를 처음 방문 했을 때만 최단 거리 기록
                if(graph[nx][ny] == 1){
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.offer(new Node(nx,ny));
                }
            }
        }

        return graph[n-1][m-1];
    }
}

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
