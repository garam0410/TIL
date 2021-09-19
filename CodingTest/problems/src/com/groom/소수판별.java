package com.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소수판별 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int num = Integer.parseInt(input);

        System.out.println(solution(num));
    }

    static String solution(int num){

        String answer = "True";

        if(num == 2){
            return "True";
        }else if(num == 1){
            return "False";
        }
        else{

            for(int i = 2; i<num; i++){
                if(num%i == 0){
                    answer = "False";
                    break;
                }
            }
            return answer;
        }
    }
}
