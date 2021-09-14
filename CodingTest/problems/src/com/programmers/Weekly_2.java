package com.programmers;

public class Weekly_2 {
    public static void main(String[] args){
        System.out.println(new Solution().solution(new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}}));
    }

    static class Solution {
        public String solution(int[][] scores) {
            // min과 max에 본인 점수가 있다면, 제외 하고 평균구하기
            String answer = "";

            for(int i = 0; i<scores.length ;i++){
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int val = scores[i][i];

                double sum = 0;
                boolean check = false;

                for(int j = 0; j<scores[i].length ;j++){
                    sum+=scores[j][i];
                    if(scores[j][i]>max)
                        max = scores[j][i];
                    else if(scores[j][i]==max && scores[j][i] == scores[i][i]){
                        check = true;
                    }

                    if(scores[j][i]<min)
                        min = scores[j][i];
                    else if(scores[j][i]==min && scores[j][i] == scores[i][i]){
                        check = true;
                    }
                }
                double result = 0;

                if((max == val || min == val) && check == false ){
                    sum -= val;
                    result = sum / (scores.length-1);
                }else{
                    result = sum / scores.length;
                }
                answer += checkGrade(result);
            }

            return answer;
        }

        static String checkGrade(double score){
            if(score>=90)
                return "A";
            else if(score>=80 && score<90)
                return "B";
            else if(score>=70 && score<80)
                return "C";
            else if(score>=50 && score<70)
                return "D";
            else
                return "F";
        }
    }
}
