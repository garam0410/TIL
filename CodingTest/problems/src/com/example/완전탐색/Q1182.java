package com.example.완전탐색;

import java.util.Scanner;

public class Q1182 {
    static int N, S, ans;
    static int[] nums;

    //k번째 원소를 포함시킬 지 정하는 함수
    // value : = k-1 번째 원소까지 골라진 원소들의 합

    static void rec_func(int k, int value){
        if(k==N+1){ // 부분수열 하나 완성
            // S와 같으면 ans++
            if(value == S)
                ans++;
        }else{
            // k번째 원소를 포함시킬지 결정하고 재귀 호출
            //추가 o
            rec_func(k+1,value+nums[k]);

            //추가 x
            rec_func(k+1,value);
       }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] val = sc.nextLine().split(" ");

        N = Integer.parseInt(val[0]);
        S = Integer.parseInt(val[1]);

        nums = new int[N+1];

        val = sc.nextLine().split(" ");

        for(int i = 1; i<=val.length; i++){
            nums[i] = Integer.parseInt(val[i-1]);
        }

        rec_func(1,0);
        if(S==0)
            ans--;
        System.out.println(ans);
    }
}
