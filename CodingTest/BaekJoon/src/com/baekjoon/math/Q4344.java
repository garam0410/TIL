package com.baekjoon.math;

import java.util.Scanner;

public class Q4344 {
    public static void main(String[] args){
        // 큐에 한줄씩 넣어서 뺴면서 값을 구한다.
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 갯수
        String cnt = sc.nextLine();

        for(int i = 0; i<Integer.parseInt(cnt); i++) {

            String[] num = sc.nextLine().split(" ");

            int sum = 0; // 점수 합
            float middleCnt = 0; // 평균 이상 학생수

            for (int j = 1; j < num.length; j++) {
                sum += Integer.parseInt(num[j]);
            }

            for (int j = 1; j < num.length; j++) {
                if (sum < Integer.parseInt(num[j]) * Integer.parseInt(num[0]))
                    middleCnt += 1;
            }

            System.out.printf("%.3f%%", middleCnt / Integer.parseInt(num[0]) * 100);

            if(i != Integer.parseInt(cnt)-1)
                System.out.println();
        }
    }
}
