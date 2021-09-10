package com.programmers;

public class Greedy_2 {
    public static void main(String[] args){
        System.out.println(new Solution().solution("JEROEN"));
        System.out.println(new Solution().solution("AABA"));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;

            //최대 커서 이동수
            int min_move = name.length()-1;

            for (int i = 0; i < name.length(); i++) {
                char alpha = name.charAt(i);
                int a = Math.abs((int) 'A' - alpha);
                int b = Math.abs((int) 'Z' - alpha);
                //answer += Math.min(a,b);
                answer += Math.min(alpha - 'A', 'Z' - alpha+1);

                int next = i+1;

                // 다음위치가 A인지 검사
                while(next<name.length() && name.charAt(next) == 'A')
                    next++;

                min_move = Math.min(min_move, i+name.length()-next+i);
            }

            answer += min_move;
            return answer;
        }
    }
}
