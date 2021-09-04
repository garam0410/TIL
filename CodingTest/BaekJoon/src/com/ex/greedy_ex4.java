package com.ex;

import java.util.Arrays;

public class greedy_ex4 {
    public static void main(String[] args){
        int K = 5;
        int[] X = {2,3,1,2,2};

        int result = 0; // 총 그룹 수
        int cnt = 0; // 현재 그룹에 포함된 모험가의 수

        Arrays.sort(X);

        for(int i = 0; i<X.length; i++){
            cnt +=1;

            if(cnt>=X[i]){
                result +=1;
                cnt = 0;
            }
        }

        System.out.println(result);
    }
}
