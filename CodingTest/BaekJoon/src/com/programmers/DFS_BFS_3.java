package com.programmers;

import java.util.HashMap;
import java.util.Map;

public class DFS_BFS_3 {
    public static void main(String[] args){
        System.out.println(new Solution().solution("hit","hot",new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(new Solution().solution("hit","cog",new String[]{"hot","dot","dog","lot","log"}));
    }

    static class Solution {
        static Map<String,String> map;
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            //최소값이니까 BFS?

            map = new HashMap<>();

            // 단어가 없을 때
            for(int i = 0; i<words.length; i++){
                if(words[i].equals(target)) break;
                if(i== words.length -1) return answer;
            }

            answer = bfs(begin,target,words);

            return answer-1;
        }

        int bfs(String begin, String target, String[] words){
            if(begin.equals(target)) return 1;
            int n = target.length();

            for(int i = 0; i<n; i++){
                if(begin.charAt(i) != target.charAt(i)){
                    StringBuilder sb = new StringBuilder(begin);
                    sb.replace(i, i+1, String.valueOf(target.charAt(i)));

                    if(map.containsKey(sb.toString())) continue;

                    for(int j = 0; j< words.length; j++){
                        if(words[j].equals(sb.toString()))
                            return bfs(sb.toString(), target, words) + 1;
                        else
                            map.put(sb.toString(),sb.toString());
                    }
                }

                for(int j = 0; j< words.length;j++){
                    if(words[j].charAt(i) != begin.charAt(i)){
                        StringBuilder sb = new StringBuilder(begin);
                        sb.replace(i,i+1,String.valueOf(words[j].charAt(i)));

                        if(map.containsKey(sb.toString())) continue;

                        for(int k = 0; k< words.length; k++){
                            if(words[k].equals(sb.toString()))
                                return bfs(sb.toString(), target, words) + 1;
                            else
                                map.put(sb.toString(),sb.toString());
                        }
                    }
                }
            }

            return 1;
        }
    }
}
