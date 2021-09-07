package com.programmers;

public class DFS_BFS_2 {
    public static void main(String[] args){
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}}));
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0},{1, 1, 1},{0, 1, 1}}));
    }
    static class Solution {

        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] check = new boolean[n];

            for(int i = 0; i<n; i++){
                if(check[i]==false){
                    dfs(computers, i, check, n);
                    answer += 1;
                }
            }

            return answer;
        }

        void dfs(int[][] computers, int i, boolean[] check, int n){
            check[i] = true;

            for(int j = 0; j<n; j++){
                if(computers[i][j] == 1 && check[j] ==false)
                    dfs(computers,j,check,n);
            }
        }
    }
}
