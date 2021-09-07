package com.programmers;

public class DFS_BFS_1 {
    public static void main(String[] args){
        System.out.println(new Solution().solution(new int[]{1,1,1,1,1}, 3));
    }

    static class Solution {
        static int answer = 0;
        static int target;
        static int[] graph;

        public int solution(int[] numbers, int target) {
            graph = numbers;
            this.target = target;
            dfs(0, numbers.length);
            return answer;
        }

        public int dfs(int n, int depth){
            if(depth-1 == -1){
                if(n==target) answer +=1;
            }
            else{
                dfs(n - graph[depth-1], depth-1);
                dfs(n + graph[depth-1], depth-1);
            }

            return answer;
        }
    }
}
