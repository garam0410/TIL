package com.ex;

public class Factorial {
    public static void main(String[] args){
        System.out.println(factorial_iterative(5));
        System.out.println(factorial_recursive(5));
    }

    //단순 반복문
    static int factorial_iterative(int n){
        int answer = 1;

        for(int i = 1; i<n+1; i++){
            answer *= i;
        }

        return answer;
    }

    //재귀 이용
    static int factorial_recursive(int n){
        if(n==1) return 1;

        int answer = n * factorial_recursive(n-1);

        return answer;
    }
}
