package com.ex;

public class DFS_ex1 {
    static int n;
    static int m;
    static int[][] graph = {{0,0,1,1,0},{0,0,0,1,1},{1,1,1,1,1},{0,0,0,0,0}};
    public static void main(String[] args){
        n = 4;
        m = 5;

        int result = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                //현재 위치에서 DFS 수행
                if (dfs(i,j)){
                    result +=1;
                }
            }
        }

        System.out.println(result);
    }

    static boolean dfs(int x, int y){
        // 범위를 벗어나면 종료
        if(x<=-1 || y<=-1 || x>=n || y>=m)
            return false;

        // 현재 노드를 방문하지 않았다면
        if(graph[x][y] == 0){
            // 방문 처리
            graph[x][y] = 1;

            //상하좌우위치 재귀 호출
            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y+1);
            dfs(x, y-1);
            return true;
        }
        return false;
    }
}
