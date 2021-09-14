package com.example.완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class Q14888 {
    // 완성된 식에 맞게 결과를 반환하는 함수
    static int calculator(int operand1, int operator, int operand2){
        if(operator == 1)
            return operand1 + operand2;
        if(operator == 2)
            return operand1 - operand2;
        if(operator == 3)
            return operand1 * operand2;
        if(operator == 4)
            return operand1 / operand2;
        return 0;
    }

    // order[]에는 연산자가 순서대로 들어감
    static void rec_func(int k, int value){
        if(k==N){ // 완성된 식에 맞게 계산을 해서 정답 갱신
//            int value = calculator();
            max = Math.max(max,value);
            min = Math.min(min,value);
        }
        else{// k번째 연산자는 무엇을 선택할까?
            for(int cand = 1; cand<=4 ; cand++){
                if(operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;
                    int new_value = calculator(value, cand, nums[k+1]);
                    rec_func(k+1, new_value);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    static int N, max, min;
    static int[] nums, operators, order;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        nums = new int[N+1];
        operators = new int[5];
        order = new int[N+1];

        String[] val = sc.nextLine().split(" ");

        for(int i = 1; i<=val.length; i++)
            nums[i] = Integer.parseInt(val[i-1]);

        val = sc.nextLine().split(" ");

        for(int i =1; i<=4; i++)
            operators[i] = Integer.parseInt(val[i-1]);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(operators));

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        rec_func(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
    }
}
