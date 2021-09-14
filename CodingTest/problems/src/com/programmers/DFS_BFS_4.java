package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DFS_BFS_4 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}})));
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}})));
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}})));
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}})));
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}})));
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}})));
    }

    static class Solution {
        static ArrayList<String> answer = new ArrayList<>();
        static String route = "";
        static boolean[] visited;
        public String[] solution(String[][] tickets) {
            for(int i = 0; i<tickets.length; i++){
                visited = new boolean[tickets.length];

                if(tickets[i][0].equals("ICN")){
                    route = "ICN" + ",";
                    visited[i] = true;
                    dfs(tickets, tickets[i][1], 1);
                }
            }

            Collections.sort(answer);
            return answer.get(0).split(",");
        }

        void dfs(String[][] tickets, String destination, int count){
            route += destination + ",";

            if(count == tickets.length){
                answer.add(route);
                return;
            }

            for(int i = 0; i< tickets.length;i++){
                if(tickets[i][0].equals(destination) && visited[i] == false){
                    visited[i] = true;
                    dfs(tickets, tickets[i][1], count +1);
                    visited[i] = false;
                    route = route.substring(0, route.length() - 4);
                }
            }
        }
    }
}
