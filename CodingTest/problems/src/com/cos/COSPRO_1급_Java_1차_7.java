package com.cos;

import java.util.Arrays;

public class COSPRO_1급_Java_1차_7 {
    static int[] solution(int[] arrA, int[] arrB) {
        int arrA_idx = 0, arrB_idx = 0;
        int arrA_len = arrA.length;
        int arrB_len = arrB.length;
        int answer[] = new int[arrA_len + arrB_len];
        int answer_idx = 0;
        while(arrA_idx != arrA_len && arrB_idx != arrB_len){ // 빈칸 채우기
            if(arrA[arrA_idx] < arrB[arrB_idx])
                answer[answer_idx++] = arrA[arrA_idx++];
            else
                answer[answer_idx++] = arrB[arrB_idx++];
        }
        while(arrA_idx != arrA_len) // 빈칸 채우기
            answer[answer_idx++] = arrA[arrA_idx++];
        while(arrB_idx != arrB_len) // 빈칸 채우기
            answer[answer_idx++] = arrB[arrB_idx++];
        return answer;
    }

    public static void main(String[] args) {
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] ret = solution(arrA, arrB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
