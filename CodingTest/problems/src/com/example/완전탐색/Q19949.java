package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q19949 {
    static int[] answer;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] vals = bf.readLine().split(" ");

        answer = new int[10];

        for(int i = 0; i<10; i++)
            answer[i] = Integer.parseInt(vals[i]);

        // 이전에 찍은 답, 동일값으로 찍은 횟수, 점수
        rec_func(0,0,0, 0);

        System.out.println(cnt);
    }

    static void rec_func(int beforeAnswer, int answerCnt, int score, int idx){
        if(idx == 10){
            if(score >= 5){
                cnt++;
            }
        }else{
            for(int i = 1; i<=5; i++){

                // 중복으로 2번 찍었을 때,
                if(beforeAnswer == i && answerCnt == 2){
                    continue;
                }

                // 중복으로 찍은 횟수가 2번 미만일 떄,
                else if(beforeAnswer == i && answerCnt < 2){

                    if(answer[idx] == i)
                        rec_func(i, answerCnt +1, score + 1, idx + 1);
                    else
                        rec_func(i, answerCnt +1, score, idx + 1);
                }

                // 중복이 아닐 떄,
                else{
                    if(answer[idx] == i)
                        rec_func(i, 1, score + 1, idx + 1);
                    else
                        rec_func(i, 1, score, idx + 1);
                }
            }
        }
    }
}