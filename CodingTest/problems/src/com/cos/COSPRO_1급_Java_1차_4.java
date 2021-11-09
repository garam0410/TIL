package com.cos;

public class COSPRO_1급_Java_1차_4 {
    static long solution(long num) {
        long answer = 0;

        String value = String.valueOf(num+1);

        answer = Long.parseLong(value.replaceAll("0","1"));

        return answer;
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        long num = 9949999;
        long ret = solution(num);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
